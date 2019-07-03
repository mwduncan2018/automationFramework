#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@LoginFeature
Feature: Login Feature
  The website should have login functionality including validations and proper redirection after a successful login

  @regression
  Scenario: Attempt to login with a blank username and blank password
    Given a blank username field
    And a blank password field
    When I login to the application
    Then a validation message for the username field is displayed
    And a validation message for the password field is displayed
    
  @regression
  Scenario Outline: A valid username and password should redirect to the flights page
    Given a valid username <username> and valid password <password> combination
    When I login to the application
    Then I am redirected to the flights page

    Examples: 
      | username  | password |
      | mduncan   | cucumber |

  @regression
  Scenario Outline: An invalid username and valid password should display a validation message
    Given an invalid username <username> and valid password <password> combination
    When I login to the application
    Then a validation message for an invalid username is displayed

    Examples: 
      | username  | password |
      | mdunca1   | cucumber |
      | angone1   | cucumber |
      | travis1   | cucumber |