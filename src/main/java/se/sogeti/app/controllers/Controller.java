package se.sogeti.app.controllers;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sogeti.app.config.Settings;
import se.sogeti.app.drivers.HttpClientSingleton;
import se.sogeti.app.models.dto.LinkDTO;

public class Controller<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    private final Gson gson;

    private final HttpClient client = HttpClientSingleton.getInstance();
    private final Settings settings = Settings.getInstance();

    public Controller() {
        this.gson = new GsonBuilder().setLenient().create();
    }

    public LinkDTO getOpenLink() {
        return gson.fromJson(callGet(settings.getApiURL().concat("/api/links/open")), LinkDTO.class);
    }

    @SuppressWarnings("unchecked")
    public T postSingle(T object, String uri) {
        T responseObject = null;

        try {
            String bodyJson = gson.toJson(object);

            HttpRequest request = HttpRequest.newBuilder().POST(BodyPublishers.ofString(bodyJson)).uri(URI.create(uri))
                    .header("Content-Type", "application/json").header("User-Agent", settings.getInternalUserAgent())
                    .build();

            CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,
                    HttpResponse.BodyHandlers.ofString());

            response.join();

            responseObject = (T) gson.fromJson(response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS),
                    object.getClass());

            Thread.sleep(500);
        } catch (InterruptedException e) {
            LOGGER.error("postSingle.InterruptedException == {}", e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            LOGGER.info("postSingle.Exception == {}, {}", e.getMessage(), e.getCause());
        }

        return responseObject;
    }

    public String callGet(String href) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(href))
                .setHeader("User-Agent", settings.getExternalUserAgent()).build();

        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,
                HttpResponse.BodyHandlers.ofString());

        response.join();

        String rtnBody = "";

        try {
            rtnBody = response.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            LOGGER.error("callGet.InterruptedException == {}", ie.getMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException ee) {
            LOGGER.error("callGet.ExecutionException == {}", ee.getMessage());
        } catch (TimeoutException te) {
            LOGGER.error("callGet.TimeoutException == {}", te.getMessage());
        }

        return rtnBody;
    }

}
