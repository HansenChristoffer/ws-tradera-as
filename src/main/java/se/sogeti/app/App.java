package se.sogeti.app;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sogeti.app.config.Constants;
import se.sogeti.app.drivers.DriverManager;
import se.sogeti.app.scrapers.AdScraper;
import se.sogeti.app.scrapers.BaseScraper;
import se.sogeti.app.scrapers.CategoryScraper;
import se.sogeti.app.scrapers.LinkScraper;

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
			menu();
		} catch (Exception e) {
			LOGGER.error("app.Exception == {}", e.getMessage());
		}
	}

	private static void menu() {
		boolean isRunning = true;

		try (Scanner in = new Scanner(System.in);) {
			while (isRunning) {
				switch (in.nextLine()) {
					case "exit":
						isRunning = false;
						break;
					case "start ls":
						linkScraperTest();
						break;
					case "start cs":
						CategoryScraper cScraper = new CategoryScraper();
						cScraper.run();
						break;
					case "start as":
						adScraperTest();
						break;
					case "killAll":
						kill();
						break;
					default:
						break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("menu().Exception == {}", e.getMessage());
			kill();
			DriverManager.closeDriver();
		} finally {
			kill();
			DriverManager.closeDriver();
		}

	}

	private static void adScraperTest() {
		try {
			AdScraper ad = new AdScraper();
			Thread t1 = new Thread(ad, "T1-AD");

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
			DriverManager.closeDriver();
		}
	}

	private static void linkScraperTest() {
		try {
			LinkScraper ls1 = new LinkScraper();
			Thread t1 = new Thread(ls1, "T1-LS");

			scrapers.addAll(Arrays.asList(ls1));
			threads.addAll(Arrays.asList(t1));

			t1.start();
			sleep(10);
			ls1.kill();
		} catch (Exception e) {
			LOGGER.error("linkScraperTest.Exception == {}", e.getMessage());
			kill();
			DriverManager.closeDriver();
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
