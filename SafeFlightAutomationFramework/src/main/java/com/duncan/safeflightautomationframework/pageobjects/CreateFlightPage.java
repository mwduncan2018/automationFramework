package com.duncan.safeflightautomationframework.pageobjects;

public class CreateFlightPage extends AbstractPage {

	public static boolean isAt() throws Exception {
		return isAt("Create Flight");
	}
	public static CreateFlightCommand createFlight() throws Exception {
		isAt();
		return new CreateFlightCommand();
	}
	public static void goTo() {
		Driver.instance.navigate().to(url + "Flights/Create");
		
	}

	
}
