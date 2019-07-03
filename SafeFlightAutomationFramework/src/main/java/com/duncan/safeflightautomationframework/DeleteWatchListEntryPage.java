package com.duncan.safeflightautomationframework;
import org.openqa.selenium.By;

public class DeleteWatchListEntryPage extends AbstractPage {

	public static boolean isAt() {
		return isAt("Delete Watch List Entry");
	}

	public static void clickButtonDelete() {
		isAt();
		Driver.instance.findElement(By.id("btnDelete")).click();
	}
}
