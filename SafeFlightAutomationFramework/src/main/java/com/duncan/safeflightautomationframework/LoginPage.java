package com.duncan.safeflightautomationframework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage extends AbstractPage {

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

}
