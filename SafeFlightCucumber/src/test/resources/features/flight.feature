@FlightFeature
Feature: Flight Feature
  This feature describes functionality of the Flight List page

  @smoke
  Scenario: Create flight, no match with watch list
    Given a flight with a name that is not on the watch list
    When the flight is created
    Then the flight is displayed on the Flight List page
    And the flight is not checked in the watch list column

	@smoke
	Scenario: Create flight, match with watch list
		Given a flight with a name that is on the watch list
		When the flight is created
		Then the flight is displayed on the Flight List page
		And the flight is checked in the watch list column
		
