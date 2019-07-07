package com.duncan.safeflightautomationframework;

public class CreateFlightPage extends AbstractPage {

	public static boolean isAt() throws Exception {
		return isAt("Create Flight");
	}
	public static CreateFlightCommand createFlight() throws Exception {
		isAt();
		return new CreateFlightCommand();
	}

	
}
