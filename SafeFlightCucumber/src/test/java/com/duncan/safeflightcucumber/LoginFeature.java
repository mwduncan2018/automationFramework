package com.duncan.safeflightcucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import com.duncan.safeflightautomationframework.CreateFlightPage;
import com.duncan.safeflightautomationframework.CreateWatchListEntryPage;
import com.duncan.safeflightautomationframework.Driver;
import com.duncan.safeflightautomationframework.FlightsPage;
import com.duncan.safeflightautomationframework.LoginPage;
import com.duncan.safeflightautomationframework.WatchListPage;

public class LoginFeature {

	@Given("we are at the login page")
	public void we_are_at_the_login_page() {
		LoginPage.goTo();
	}

	@When("I login with a blank username field and a blank password field")
	public void I_login_with_a_blank_username_field_and_a_blank_password_field() {
		LoginPage.loginAs("").withPassword("").login();
	}

	@Then("a validation message for the username field is displayed")
	public void a_validation_message_for_the_username_field_is_displayed() {
		assertTrue(LoginPage.usernameValidationIsDisplayed());
	}

	@Then("a validation message for the password field is displayed")
	public void a_validation_message_for_the_password_field_is_displayed() {
		assertTrue(LoginPage.passwordValidationIsDisplayed());
	}

}
