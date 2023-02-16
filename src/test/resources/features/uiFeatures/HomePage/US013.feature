# HomePage US013 User should be able to perform various operations on homepage



# Vural
Feature: US013_TC_001, The "Register Now" heading under the Contribution to the Environment and
  Society heading should be clickable
  Background:
    Given user goes to "https://test.urbanicfarm.com/"

  @UI
  @US013
  Scenario: The "Register Now" heading should be clickable
    And user goes to the "Contribution to the Environment and Society" heading
    And user waits 2 seconds
    Then user verifies that the "Register Now" heading is clickable