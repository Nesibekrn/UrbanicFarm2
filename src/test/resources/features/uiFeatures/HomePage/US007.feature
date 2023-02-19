
Feature: US_007_TC_001_Login should be clickable and Login page should be visible


  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US007
  Scenario: To check if Login link is clickable and passing to Login page when it clicked
    And User checks the Login button is clickable
    Then User clicks Login button
    Then User verifies if Login page is visible