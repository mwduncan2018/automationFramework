@LoginFeature
Feature: Login Feature
  There should be login functionality including validations and proper redirection after a successful login

  @smoke
  Scenario: Blank username, blank password
    Given we are at the login page
    And I login with a blank username field and a blank password field
    Then a validation message stating that the username field is required is displayed
    And a validation message stating that the password field is required is displayed
    
	@smoke
	Scenario: Valid username, valid password
		Given we are at the login page
		And I login with a valid username field and a valid password field
		Then I am at the flights page
		
  @regression
  Scenario Outline: Valid username, valid password, data driven
    Given we are at the login page
		And I login with username "<username>" and password "<password>"
		Then I am at the flights page

    Examples: 
      | username  | password |
      | mduncan   | cucumber |
      | tduncan   | airforce1 |
      | eangone   | achievedhappiness |
      | sharford  | michigan |
      | gduncan   | mommom |

  @regression
  Scenario Outline: Invalid username, invalid password, data driven
    Given we are at the login page
		And I login with username "<username>" and password "<password>"
		Then a validation message stating that the username and password combination is invalid is displayed

    Examples: 
      | username  | password |
      | mdunca1   | cucumber |
      | angone1   | cucumber |
      | travis1   | cucumber |