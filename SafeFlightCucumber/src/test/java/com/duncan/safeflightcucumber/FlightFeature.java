package com.duncan.safeflightcucumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import com.duncan.safeflightautomationframework.pageobjects.Driver;
import com.duncan.safeflightautomationframework.pageobjects.FlightsPage;
import com.duncan.safeflightautomationframework.pageobjects.LoginPage;
import com.duncan.safeflightautomationframework.pageobjects.WatchListPage;
import com.duncan.safeflightautomationframework.pageobjects.CreateFlightPage;
import com.duncan.safeflightautomationframework.pageobjects.CreateWatchListEntryPage;
import com.duncan.safeflightautomationframework.testdata.Flight;
import com.duncan.safeflightautomationframework.testdata.WatchListEntry;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;

public class FlightFeature {

	private Flight flight = null;
	private WatchListEntry watchListEntry = null;

	private void cleanupTestData() throws Exception {
		if (flight != null) {
			FlightsPage.goTo();
			FlightsPage.deleteFlight(flight.getLastName(), flight.getFirstName());
		}
		if (watchListEntry != null) {
			WatchListPage.goTo();
			WatchListPage.deleteUserFromWatchList(watchListEntry.getLastName(), watchListEntry.getFirstName());
		}
	}

	@Before
	public void beforeScenario() {
		flight = null;
		Driver.initialize();
	}

	@After
	public void afterScenario() throws Exception {
		cleanupTestData();
	}

	@Given("a flight with a name that is not on the watch list")
	public void a_flight_with_a_name_that_is_not_on_the_watch_list() throws Exception {
		flight = new Flight();
		flight.setDepartureAirport("Seattle");
		flight.setDepartureTime("7/7/2019 6:25:00 PM");
		flight.setArrivalAirport("LAX");
		flight.setArrivalTime("7/7/2019 10:25:00 PM");
		flight.setFirstName("Ben");
		flight.setLastName("Linus");
	}

	@Given("a flight with a name that is on the watch list")
	public void a_flight_with_a_name_that_is_on_the_watch_list() throws Exception {
		flight = new Flight();
		flight.setArrivalAirport("Mexico City");
		flight.setArrivalTime("7/6/2019 7:30:00 PM");
		flight.setDepartureAirport("Miami");
		flight.setDepartureTime("7/6/2019 11:30:00 PM");
		flight.setFirstName("Frederich");
		flight.setLastName("Nietzsche");
	}

	@Given("a flight with first name {string} and last name {string}")
	public void a_flight_with_first_name_and_last_name(String firstName, String lastName) throws Exception {
		flight = new Flight();
		flight.setDepartureAirport("Atlanta");
		flight.setDepartureTime("5/7/2019 6:25:00 PM");
		flight.setArrivalAirport("Chicago");
		flight.setArrivalTime("5/7/2019 10:25:00 PM");
		flight.setFirstName(firstName);
		flight.setLastName(lastName);
	}

	@Given("a watch list entry with first name {string} and last name {string}")
	public void a_watch_list_entry_with_first_name_and_last_name(String firstName, String lastName) throws Exception {
		watchListEntry = new WatchListEntry();
		watchListEntry.setBounty(99000);
		watchListEntry.setFirstName(firstName);
		watchListEntry.setLastName(lastName);
	}

	@When("the flight is created")
	public void the_flight_is_created() throws Exception {
		CreateFlightPage.goTo();
		CreateFlightPage.createFlight().withArrivalAirport(flight.getArrivalAirport())
				.withArrivalTime(flight.getArrivalTime()).withDepartureAirport(flight.getDepartureAirport())
				.withDepartureTime(flight.getDepartureTime()).withFirstName(flight.getFirstName())
				.withLastName(flight.getLastName()).submit();
	}

	@When("the watch list entry is created")
	public void the_watch_list_entry_is_created() throws Exception {
		WatchListPage.goTo();
		WatchListPage.clickLinkCreateNew();
		CreateWatchListEntryPage.createEntry().withBounty(watchListEntry.getBounty())
				.withFirstName(watchListEntry.getFirstName()).withLastName(watchListEntry.getLastName()).submit();
	}

	@Then("the flight is displayed on the Flight List page")
	public void the_flight_is_displayed_on_the_Flight_List_page() throws Exception {
		FlightsPage.goTo();
		assertTrue(FlightsPage.flightIsDisplayed(flight));
	}

	@Then("the flight is not checked in the watch list column")
	public void the_flight_is_not_checked_in_the_watch_list_column() throws Exception {
		FlightsPage.goTo();
		assertFalse(FlightsPage.watchListIsCheckedFor(flight.getLastName(), flight.getFirstName()));
	}

	@Then("the flight is checked in the watch list column")
	public void the_flight_is_checked_in_the_watch_list_column() throws Exception {
		FlightsPage.goTo();
		assertTrue(FlightsPage.watchListIsCheckedFor(flight.getLastName(), flight.getFirstName()));
	}

	@Then("the flight with first name {string} and last name {string} is checked in the watch list column")
	public void the_flight_with_first_name_and_last_name_is_checked_in_the_watch_list_column(String firstName, String lastName) throws Exception {
		FlightsPage.goTo();
		assertTrue(FlightsPage.watchListIsCheckedFor(lastName, firstName));
	}

	@Then("the flight with first name {string} and last name {string} is not checked in the watch list column")
	public void the_flight_with_first_name_and_last_name_is_not_checked_in_the_watch_list_column(String firstName, String lastName) throws Exception {
		FlightsPage.goTo();
		assertFalse(FlightsPage.watchListIsCheckedFor(firstName, lastName));
	}

}