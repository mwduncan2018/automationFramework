package com.duncan.safeflightautomationframework;

public class UnexpectedPageException extends Exception {

	public UnexpectedPageException(String expectedPage, String actualPage) {
		super("CUSTOM EXCEPTION ---> UnexpectedPageException ---> ExpectedPage: " + expectedPage + " ---> ActualPage: " + actualPage);
	}

}
