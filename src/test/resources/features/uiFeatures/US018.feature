Feature: US018 User should be able to perform various operations on homepage

  Background:
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US018
  Scenario: US018/ Get The App should be clickable and visible
    When User scrolls down
    And User clicks on the Get The App
    Then User verifies Get The App visible