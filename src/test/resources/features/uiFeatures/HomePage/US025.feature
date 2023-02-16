Feature: US_031, User should be able to perform various operations on homepage

  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    And user goes to bottom page
  @UI
  @US_025
  Scenario: US_025, TC001_User should be able to perform various operations on homepage
    And user clicks on phone
    Then user verifies that "Make a call from" box is visible