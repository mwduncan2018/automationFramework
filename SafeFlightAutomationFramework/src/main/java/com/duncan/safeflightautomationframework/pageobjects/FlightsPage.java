package com.duncan.safeflightautomationframework.pageobjects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.duncan.safeflightautomationframework.testdata.Flight;

public class FlightsPage extends AbstractPage {

	private static List<WebElement> refreshFirstNameColumn() {
		return Driver.instance.findElements(By.id("firstName"));		
	}
	private static List<WebElement> refreshLastNameColumn() {
		return Driver.instance.findElements(By.id("lastName"));
	}
	private static List<WebElement> refreshWatchListColumn() {
		return Driver.instance.findElements(By.cssSelector("#watchList > input"));
	}
	
	public static boolean isAt() throws Exception {
		return isAt("Flight List");
	}

	public static boolean watchListIsCheckedFor(String lastName, String firstName) throws Exception {
		isAt();

		List<WebElement> firstNameColumn = refreshFirstNameColumn();
		List<WebElement> lastNameColumn = refreshLastNameColumn();
		List<WebElement> watchListColumn = refreshWatchListColumn();
		
		int index = 0;
		for (WebElement firstNameElement : firstNameColumn) {
			if (firstNameElement.getText().equals(firstName)) {
				if (lastNameColumn.get(index).getText().equals(lastName)) {
					if (watchListColumn.get(index).isSelected()) {
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

	public static void goTo() {
		Driver.instance.navigate().to(url + "Flights");
	}

	public static boolean flightIsDisplayed(Flight flight) throws Exception {
		isAt();
		
		List<WebElement> firstNameList = Driver.instance.findElements(By.id("firstName"));
		List<WebElement> lastNameList = Driver.instance.findElements(By.id("lastName"));
		
		return false;
	}

}
