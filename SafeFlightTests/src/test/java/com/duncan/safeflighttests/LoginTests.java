package com.duncan.safeflighttests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.duncan.safeflightautomationframework.FlightsPage;
import com.duncan.safeflightautomationframework.LoginPage;

class LoginTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void user_can_login() throws Exception {

		LoginPage.goTo();
		LoginPage.loginAs("mduncan").withPassword("cucumber").login();
		assertTrue(FlightsPage.isAt());

	}

}
