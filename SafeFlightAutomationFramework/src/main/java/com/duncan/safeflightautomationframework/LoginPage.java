package com.duncan.safeflightautomationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage extends AbstractPage {

	static final By usernameValidation = By.id("Username-error");
	static final By passwordValidation = By.id("Password-error");
	static final By validationSummary = By.id("viewBagValidationSummary");
	
	public static boolean isAt() throws Exception {
		return isAt("Login");
	}

	public static void goTo() {
		String url = "http://localhost:60030/Login";
		Driver.instance.navigate().to(url);
	}

	public static LoginCommand loginAs(String username) throws Exception {
		isAt();
		return new LoginCommand(username);
	}

	public static boolean usernameValidationIsDisplayed() throws Exception {
		isAt();
		return Driver.instance.findElement(usernameValidation).getText().equals("The Username field is required.");
	}

	public static boolean passwordValidationIsDisplayed() throws Exception {
		isAt();
		return Driver.instance.findElement(passwordValidation).getText().equals("The Password field is required.");
	}

	public static boolean validationUsernamePasswordCombinationInvalid() throws Exception {
		isAt();
		return Driver.instance.findElement(validationSummary).getText().equals("The username/password combination is invalid.");
	}
}
