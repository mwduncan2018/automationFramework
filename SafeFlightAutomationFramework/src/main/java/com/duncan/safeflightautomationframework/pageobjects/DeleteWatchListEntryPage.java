package com.duncan.safeflightautomationframework.pageobjects;
import org.openqa.selenium.By;

public class DeleteWatchListEntryPage extends AbstractPage {

	public static boolean isAt() throws Exception {
		return isAt("Delete Watch List Entry");
	}

	public static void clickButtonDelete() throws Exception {
		isAt();
		Driver.instance.findElement(By.id("btnDelete")).click();
	}
}
