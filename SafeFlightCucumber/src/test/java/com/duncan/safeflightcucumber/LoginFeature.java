package com.duncan.safeflightcucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import com.duncan.safeflightautomationframework.pageobjects.CreateFlightPage;
import com.duncan.safeflightautomationframework.pageobjects.CreateWatchListEntryPage;
import com.duncan.safeflightautomationframework.pageobjects.Driver;
import com.duncan.safeflightautomationframework.pageobjects.FlightsPage;
import com.duncan.safeflightautomationframework.pageobjects.LoginPage;
import com.duncan.safeflightautomationframework.pageobjects.WatchListPage;

public class LoginFeature {

	@Before
	public void beforeScenario() {
		Driver.initialize();
	}
	
	@After
	public void afterScenario() {
	}
	
	@Given("we are at the login page")
	public void we_are_at_the_login_page() {
		LoginPage.goTo();
	}

	@When("I login with a blank username field and a blank password field")
	public void I_login_with_a_blank_username_field_and_a_blank_password_field() throws Exception {
		LoginPage.loginAs("").withPassword("").login();
	}

	@When("I login with a valid username field and a valid password field")
	public void I_login_with_a_valid_username_field_and_a_valid_password_field() throws Exception {
		LoginPage.loginAs("mduncan").withPassword("cucumber").login();
	}
	
	@Then("a validation message stating that the username field is required is displayed")
	public void a_validation_message_stating_that_the_username_field_is_required_is_displayed() throws Exception {
		assertTrue(LoginPage.usernameValidationIsDisplayed());
	}

	@Then("a validation message stating that the password field is required is displayed")
	public void a_validation_message_stating_that_the_password_field_is_required_is_displayed() throws Exception {
		assertTrue(LoginPage.passwordValidationIsDisplayed());
	}

	@Then("a validation message stating that the username and password combination is invalid is displayed")
	public void a_validation_message_stating_that_the_username_and_password_combination_is_invalid_is_displayed() throws Exception {
		assertTrue(LoginPage.validationUsernamePasswordCombinationInvalid());
	}
	
	@Then("I am at the flights page")
	public void I_am_at_the_flights_page() throws Exception {
		assertTrue(FlightsPage.isAt());
	}
	
	@Given("I login with username {string} and password {string}")
	public void I_login_with_username_and_password(String username, String password) throws Exception {
		LoginPage.loginAs(username).withPassword(password).login();
	}
	

}
