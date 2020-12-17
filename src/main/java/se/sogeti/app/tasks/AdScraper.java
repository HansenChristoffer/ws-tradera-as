package se.sogeti.app.tasks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sogeti.app.config.Settings;
import se.sogeti.app.database.Database;
import se.sogeti.app.models.ItemDetails;
import se.sogeti.app.models.dto.AdvertDTO;
import se.sogeti.app.models.dto.SellerDTO;

public class AdScraper extends BaseTask {

  public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

  private Database<AdvertDTO> advertDatabase = new Database<>();
  private Database<SellerDTO> sellerDatabase = new Database<>();

  private final Settings settings = Settings.getInstance();

  public AdScraper(long n, String id) {
    super(n, id);
  }

  @Override
  public void run() {
    settings.updateSettings();

    Date d = new Date();
    DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");

    long startTime = System.currentTimeMillis();
    d.setTime(startTime);
    LOGGER.info("Starting task {} at {}", super.id, df.format(d));

    try {
      while (Boolean
          .parseBoolean(advertDatabase.callGet(settings.getApiURL().concat("/api/status/isActive?value=as")))) {
        LOGGER.info("Fetching open link...");
        Object[] data = getData(advertDatabase.fetchOpenLink().getHref());

        SellerDTO seller = (SellerDTO) data[0];
        AdvertDTO advert = (AdvertDTO) data[1];

        LOGGER.info("Sending SellerDTO...");
        sellerDatabase.postSingle(seller, settings.getApiURL().concat("/api/sellers"));

        LOGGER.info("Sending AdvertDTO...");
        advertDatabase.postSingle(advert, settings.getApiURL().concat("/api/adverts"));

        randomizedSleep(1.5, 2.5);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    } finally {
      long endTime = System.currentTimeMillis();
      d.setTime(endTime);
      LOGGER.info("Ending task {} at {} after {} s", super.id, df.format(d), (endTime - startTime) / 1000);
    }
  }

  private Object[] getData(String url) {
    Gson gson = new Gson();
    String jsonURL = settings.getBaseUrl().concat("/item/").concat(url.split("/")[5]).concat(".json");
    LOGGER.info("Scraping data from URL, {}", jsonURL);

    JsonObject json = JsonParser.parseString(advertDatabase.callGet(jsonURL)).getAsJsonObject().get("itemDetails")
        .getAsJsonObject();

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

}
