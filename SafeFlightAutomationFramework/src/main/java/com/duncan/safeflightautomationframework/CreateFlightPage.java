package com.duncan.safeflightautomationframework;

public class CreateFlightPage extends AbstractPage {

	public static boolean isAt() {
		return isAt("Create Flight");
	}
	public static CreateFlightCommand createFlight() {
		isAt();
		return new CreateFlightCommand();
	}

	
}
