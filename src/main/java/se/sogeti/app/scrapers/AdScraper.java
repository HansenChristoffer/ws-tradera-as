package se.sogeti.app.scrapers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sogeti.app.config.Constants;
import se.sogeti.app.database.Database;
import se.sogeti.app.drivers.HttpClientSingleton;
import se.sogeti.app.models.ItemDetails;
import se.sogeti.app.models.dto.AdvertDTO;
import se.sogeti.app.models.dto.SellerDTO;

public class AdScraper implements Runnable, BaseScraper {

  public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

  private volatile boolean isRunning = true;
  private Database<AdvertDTO> advertDatabase = new Database<>();
  private Database<SellerDTO> sellerDatabase = new Database<>();

  private final HttpClient client = HttpClientSingleton.getInstance();

  @Override
  public void run() {
    long elapsedTime = System.currentTimeMillis();
    try {
      while (isRunning) {
        LOGGER.info("Fetching open link...");
        Object[] data = getData(advertDatabase.fetchOpenLink().getHref());

        SellerDTO seller = (SellerDTO) data[0];
        AdvertDTO advert = (AdvertDTO) data[1];

        LOGGER.info("Sending SellerDTO...");
        sellerDatabase.postSingle(seller,
            "http://".concat(Constants.databaseIp).concat(":").concat(Constants.databasePort).concat("/api/sellers"));

        LOGGER.info("Sending AdvertDTO...");
        advertDatabase.postSingle(advert,
            "http://".concat(Constants.databaseIp).concat(":").concat(Constants.databasePort).concat("/api/adverts"));

        randomizedSleep(1.5, 2.5);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      kill();
    } finally {
      LOGGER.info("Elapsed time: {}s", (System.currentTimeMillis() - elapsedTime) / 1000);
    }
  }

  private Object[] getData(String url) {
    Gson gson = new Gson();
    String jsonURL = Constants.BASE_URL.concat("/item/").concat(url.split("/")[5]).concat(".json");
    LOGGER.info("getData().jsonURL == {}", jsonURL);

    JsonObject json = JsonParser.parseString(callGet(jsonURL)).getAsJsonObject().get("itemDetails").getAsJsonObject();

    ItemDetails itemDetails = gson.fromJson(String.valueOf(json), ItemDetails.class);

    SellerDTO seller = itemDetails.getSeller().build();
    AdvertDTO advert = itemDetails.build();

    advert.setCanonicalURL(url.substring(23));

    List<byte[]> images = new ArrayList<>();
    itemDetails.getImages().forEach(image -> images.add(getImageInBytes(image.getFullSize())));

    advert.setImages(images);

    return new Object[] { seller, advert };
  }

  private byte[] getImageInBytes(String imageURL) {
    try {
      BufferedImage image = ImageIO.read(new URL(imageURL));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();

      ImageIO.write(image, "jpg", baos);
      byte[] imageBytes = baos.toByteArray();

      baos.flush();
      baos.close();

      return imageBytes;
    } catch (IOException e) {
      LOGGER.error("{}", e.getMessage());
    }

    return new byte[0];
  }

  public String callGet(String href) {
    HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(href))
        .setHeader("User-Agent", Constants.EXTERNAL_USER_AGENT).build();

    CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    response.join();

    String bodyJson = "";

    try {
      bodyJson = response.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
    } catch (InterruptedException ie) {
      LOGGER.error("callGet.InterruptedException == {}", ie.getMessage());
      Thread.currentThread().interrupt();
    } catch (ExecutionException ee) {
      LOGGER.error("callGet.ExecutionException == {}", ee.getMessage());
    } catch (TimeoutException te) {
      LOGGER.error("callGet.TimeoutException == {}", te.getMessage());
    }

    return bodyJson;
  }

  /**
   * Function that randomizes a number between given parameters and uses that to
   * sleep the current Thread. Remember that the parameters are in seconds and not
   * milliseconds!
   * 
   * @param minimum integer value for the minimum range of the randomization
   * @param maximum integer value for the maximum range of the randomization
   */
  public void randomizedSleep(double minimum, double maximum) {
    try {
      Random r = new Random();
      if (minimum < maximum && (minimum <= 19 && maximum <= 20)) {
        Thread.sleep((r.nextInt((int) (maximum * 1000)) + (int) (minimum * 1000)));
      } else {
        Thread.sleep((r.nextInt(3000) + 1000));
      }
    } catch (InterruptedException e) {
      LOGGER.error("randomizedSleep().InterruptedException == {}", e.getMessage());
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public void kill() {
    isRunning = false;
  }
}
