package com.duncan.safeflightautomationframework;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightsPage extends AbstractPage {

	public static boolean isAt() throws Exception {
		return isAt("Flight List");
	}

	public static boolean watchListIsCheckedFor(String lastName, String firstName) throws Exception {
		isAt();

		List<WebElement> firstNameList = Driver.instance.findElements(By.id("firstName"));
		List<WebElement> lastNameList = Driver.instance.findElements(By.id("lastName"));
		List<WebElement> watchList = Driver.instance.findElements(By.cssSelector("#watchList > input"));
		
		int index = 0;
		for (WebElement firstNameElement : firstNameList) {
			if (firstNameElement.getText().equals(firstName)) {
				if (lastNameList.get(index).getText().equals(lastName)) {
					if (watchList.get(index).isSelected()) {
						return true;
					}
				}
			}
			index++;
		}
		
		return false;
	}

	public static void clickLinkCreateFlight() throws Exception {
		isAt();
		Driver.instance.findElement(By.linkText("Create New")).click();		
	}

	public static void clickLinkWatchList() throws Exception {
		isAt();
		Driver.instance.findElement(By.linkText("Watch List")).click();
	}

	public static void deleteFlight(String lastName, String firstName) throws Exception {
		isAt();
		
		List<WebElement> firstNameList = Driver.instance.findElements(By.id("firstName"));
		List<WebElement> lastNameList = Driver.instance.findElements(By.id("lastName"));
		List<WebElement> deleteList = Driver.instance.findElements(By.linkText("Delete"));
		
		int index = 0;
		for (WebElement firstNameElement : firstNameList) {
			if (firstNameElement.getText().equals(firstName)) {
				if (lastNameList.get(index).getText().equals(lastName)) {
					deleteList.get(index).click();
					DeleteFlightPage.clickButtonDelete();
				}
			}
			index++;
		}
		
	}

}
