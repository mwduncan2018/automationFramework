package com.duncan.safeflightautomationframework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static WebDriver instance;
	
	public static void initialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mwdun\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		instance = new FirefoxDriver();
		instance.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
	}

	public static void close() {
		instance.close();
	}
}
