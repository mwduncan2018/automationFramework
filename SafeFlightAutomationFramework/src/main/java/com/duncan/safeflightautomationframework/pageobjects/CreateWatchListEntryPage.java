package com.duncan.safeflightautomationframework.pageobjects;

public class CreateWatchListEntryPage extends AbstractPage {

	public static boolean isAt() throws Exception {
		return isAt("Create Watch List Entry");
	}

	public static CreateWatchListEntryCommand createEntry() throws Exception {
		isAt();
		return new CreateWatchListEntryCommand();
	}

}
