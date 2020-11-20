package se.sogeti.app;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sogeti.app.config.Constants;
import se.sogeti.app.scrapers.AdScraper;
import se.sogeti.app.scrapers.BaseScraper;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
	private static Set<BaseScraper> scrapers = new HashSet<>();
	private static Set<Thread> threads = new HashSet<>();

	public static void main(String[] args) {
		Constants.init();
		app();
	}

	private static void app() {
		try {
			//
		} catch (Exception e) {
			LOGGER.error("app.Exception == {}", e.getMessage());
		}
	}

	private static void adscraperRun() {
		try {
			AdScraper ad = new AdScraper();
			Thread t1 = new Thread(ad, "WS-T-AS");

			scrapers.addAll(Arrays.asList(ad));
			threads.addAll(Arrays.asList(t1));

			t1.start(); // Starts thread 1
			sleep(30);
			ad.kill(); // Send kill order to the Adscraper (Which is being run by the
			// Thread named
			// "t1")
		} catch (Exception e) {
			LOGGER.error("adScraperTest.Exception == {}", e.getMessage());
			kill();
		}
	}

	private static void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			LOGGER.error("sleep.InterruptedException == {}", e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

	private static void kill() {
		try {
			if (!scrapers.isEmpty()) {
				scrapers.forEach(s -> s.kill());
				scrapers.clear();
			}
		} catch (Exception e) {
			LOGGER.info("kill().Exception == {}", e.getMessage());
		}
	}

}
