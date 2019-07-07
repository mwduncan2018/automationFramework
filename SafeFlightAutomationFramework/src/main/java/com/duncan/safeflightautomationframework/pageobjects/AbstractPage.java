package com.duncan.safeflightautomationframework.pageobjects;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

	protected static String url = "http://localhost:60030/";
	
	protected static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

	protected static boolean isAt(String expectedPageName) throws UnexpectedPageException {
		String actualPageName = Driver.instance.findElement(By.id("pageName")).getText();
		if (actualPageName.equals(expectedPageName)) {
			logger.log(Level.ALL, "Page successfully found: " + expectedPageName);
			return true;
		} else {
			logger.log(Level.ALL, "WARNING! Not on expected page: " + expectedPageName);
			throw new UnexpectedPageException(expectedPageName, actualPageName);
		}
	}
}
