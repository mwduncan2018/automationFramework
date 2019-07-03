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
    Given we are at the login page
    And I login with a blank username field and a blank password field
    Then a validation message for the username field is displayed
    And a validation message for the password field is displayed
    
