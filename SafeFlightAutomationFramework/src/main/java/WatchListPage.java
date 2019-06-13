import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WatchListPage extends AbstractPage {

	public static boolean isAt() {
		return isAt("Watch List");
	}

	public static void clickLinkCreateNew() {
		isAt();
		Driver.instance.findElement(By.linkText("Create New")).click();
	}

	public static void clickLinkFlightList() {
		isAt();
		Driver.instance.findElement(By.linkText("Flight List")).click();
	}

	public static void deleteUserFromWatchList(String lastName, String firstName) {
		isAt();
		
		List<WebElement> bountyList = Driver.instance.findElements(By.id("bounty"));
		List<WebElement> firstNameList = Driver.instance.findElements(By.id("firstName"));
		List<WebElement> lastNameList = Driver.instance.findElements(By.id("lastName"));
		List<WebElement> deleteList = Driver.instance.findElements(By.linkText("Delete"));

		int index = 0;
		for (WebElement firstNameElement : firstNameList) {
			if (firstNameElement.getText().equals(firstName)) {
				if (lastNameList.get(index).getText().equals(lastName)) {
					deleteList.get(index).click();
					DeleteWatchListEntryPage.clickButtonDelete();
				}
			}
			index++;
		}
	}

}
