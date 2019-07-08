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

  @regression
  Scenario Outline: Create flight, no match with watch list, data driven
    Given a flight with first name "<firstName>" and last name "<lastName>"
    When the flight is created
    Then the flight is displayed on the Flight List page
    And the flight with first name "<firstName>" and last name "<lastName>" is not checked in the watch list column

    Examples: 
      | firstName  | lastName |
      | James      | Hetfield |
      | Kirk       | Hammett  |
      | Dave       | Mustaine |

	@regression
	Scenario Outline: Create flight, match with watch list, data driven
		Given a flight with first name "<firstName>" and last name "<lastName>"
		And a watch list entry with first name "<firstName>" and last name "<lastName>"
		When the flight is created
		And the watch list entry is created
		Then the flight is displayed on the Flight List page
		And the flight with first name "<firstName>" and last name "<lastName>" is checked in the watch list column
		
    Examples: 
      | firstName  | lastName |
      | Reinhold   | Bogner   |
      | Randall    | Smith    |
      | Jerry      | Seinfeld |