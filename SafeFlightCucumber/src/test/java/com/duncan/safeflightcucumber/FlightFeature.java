package com.duncan.safeflightcucumber;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import com.duncan.safeflightautomationframework.pageobjects.Driver;
import com.duncan.safeflightautomationframework.pageobjects.FlightsPage;
import com.duncan.safeflightautomationframework.pageobjects.CreateFlightPage;
import com.duncan.safeflightautomationframework.testdata.Flight;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;

public class FlightFeature {

	private Flight flight;

	private void cleanupTestData() throws Exception {
		if (flight != null) {
			FlightsPage.deleteFlight(flight.getLastName(), flight.getFirstName());
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
		Driver.close();
	}

	@Given("a flight with a name that is not on the watch list")
	public void a_flight_with_a_name_that_is_not_on_the_watch_list() throws Exception {
		flight = new Flight();
		flight.setArrivalAirport("LAX");
		flight.setArrivalTime(LocalDateTime.now());
		flight.setDepartureAirport("Seattle");
		flight.setDepartureTime(LocalDateTime.now().plusHours(4));
		flight.setFirstName("Ben");
		flight.setLastName("Linus");
	}

	@Given("a flight with a name that is on the watch list")
	public void a_flight_with_a_name_that_is_on_the_watch_list() throws Exception {
		flight = new Flight();
		flight.setArrivalAirport("Mexico City");
		flight.setArrivalTime(LocalDateTime.now());
		flight.setDepartureAirport("Miami");
		flight.setDepartureTime(LocalDateTime.now().plusHours(4));
		flight.setFirstName("Frederich");
		flight.setLastName("Nietzsche");
	}

	@When("the flight is created")
	public void the_flight_is_created() throws Exception {
		CreateFlightPage.createFlight().withArrivalAirport(flight.getArrivalAirport())
				.withArrivalTime(flight.getArrivalTime().toString()).withDepartureAirport(flight.getDepartureAirport())
				.withDepartureTime(flight.getDepartureTime().toString()).withFirstName(flight.getFirstName())
				.withLastName(flight.getLastName()).submit();
	}

	@Then("the flight is displayed on the Flight List page")
	public void the_flight_is_displayed_on_the_Flight_List_page() throws Exception {
		assertTrue(FlightsPage.flightIsDisplayed(flight));
	}

	@Then("the flight is not checked in the watch list column")
	public void the_flight_is_not_checked_in_the_watch_list_column() throws Exception {

	}

	@Then("the flight is checked in the watch list column")
	public void the_flight_is_checked_in_the_watch_list_column() throws Exception {

	}
}
