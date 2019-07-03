package com.duncan.safeflightautomationframework;
import org.openqa.selenium.By;

public class DeleteFlightPage extends AbstractPage {

	public static boolean isAt() {
		return isAt("Delete Flight");
	}
	public static void clickButtonDelete() {
		isAt();
		Driver.instance.findElement(By.id("btnDelete")).click();
	}

}
