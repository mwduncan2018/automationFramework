package com.duncan.safeflightautomationframework.pageobjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static WebDriver instance = null;
	
	public static void initialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mwdun\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		if (instance == null) {
			instance = new FirefoxDriver();			
		}
		instance.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
	}

	public static void close() {
		//instance.close();
		//instance = null;
	}
}
