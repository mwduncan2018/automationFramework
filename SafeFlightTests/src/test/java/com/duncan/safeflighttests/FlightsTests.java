package com.duncan.safeflighttests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.duncan.safeflightautomationframework.pageobjects.CreateFlightPage;
import com.duncan.safeflightautomationframework.pageobjects.CreateWatchListEntryPage;
import com.duncan.safeflightautomationframework.pageobjects.Driver;
import com.duncan.safeflightautomationframework.pageobjects.FlightsPage;
import com.duncan.safeflightautomationframework.pageobjects.LoginPage;
import com.duncan.safeflightautomationframework.pageobjects.WatchListPage;

class FlightsTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Driver.initialize();
	}

	@AfterEach
	void tearDown() throws Exception {
		Driver.close();
	}

	@Test
	void michael_duncan_is_checked_in_the_watch_list_column() throws Exception {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("cucumber").login();

		assertTrue(FlightsPage.watchListIsCheckedFor("Duncan", "Michael"));
	}

	@Test
	void travis_duncan_is_not_checked_in_the_watch_list_column() throws Exception {
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("cucumber").login();

		assertTrue(!FlightsPage.watchListIsCheckedFor("Duncan", "Travis"));
	}

	@Test
	void add_a_flight_and_add_the_user_to_the_watch_list_and_verify_the_user_is_checked_on_the_flights_page() throws Exception {
		// Login
		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("cucumber").login();

		// Create a flight
		FlightsPage.clickLinkCreateFlight();
		CreateFlightPage.createFlight().withDepartureAirport("BWI").withArrivalAirport("Philly")
				.withDepartureTime("2/2/2019 4:12:00 PM").withArrivalTime("2/2/2019 5:12:00 PM").withFirstName("Jeremy")
				.withLastName("Benthem").submit();
		FlightsPage.clickLinkWatchList();
		
		// Add the same person to the watch list
		WatchListPage.clickLinkCreateNew();
		CreateWatchListEntryPage.createEntry().withBounty(10000).withFirstName("Jeremy").withLastName("Benthem").submit();
		WatchListPage.clickLinkFlightList();
		
		// Assert the person is checked on the Flights page
		assertTrue(FlightsPage.watchListIsCheckedFor("Benthem", "Jeremy"));
		
		// Remove the person from the watch list
		FlightsPage.clickLinkWatchList();		
		WatchListPage.deleteUserFromWatchList("Benthem", "Jeremy");
		WatchListPage.clickLinkFlightList();
		
		// Delete the flight
		FlightsPage.deleteFlight("Benthem", "Jeremy");
	}
}
