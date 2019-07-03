package com.duncan.safeflightautomationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage extends AbstractPage {

	static final By usernameValidation = By.id("Username-error");
	static final By passwordValidation = By.id("Password-error");

	public static boolean isAt() {
		return isAt("Login");
	}

	public static void goTo() {
		String url = "http://localhost:60030/Login";
		Driver.instance.navigate().to(url);
	}

	public static LoginCommand loginAs(String username) {
		isAt();
		return new LoginCommand(username);
	}

	public static boolean usernameValidationIsDisplayed() {
		isAt();
		return Driver.instance.findElement(usernameValidation).getText().equals("The Username field is required");
	}

	public static boolean passwordValidationIsDisplayed() {
		isAt();
		return Driver.instance.findElement(passwordValidation).getText().equals("The Password field is required.");
	}

}
