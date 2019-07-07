package com.duncan.safeflightautomationframework.pageobjects;

public class UnexpectedPageException extends Exception {

	public UnexpectedPageException(String expectedPage, String actualPage) {
		super("CUSTOM EXCEPTION ---> UnexpectedPageException ---> ExpectedPage: " + expectedPage + " ---> ActualPage: " + actualPage);
	}

}
