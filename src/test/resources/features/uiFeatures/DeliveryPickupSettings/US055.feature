Feature: As a user I should be able to perform various actions in the Delivery & Pick up settings section
Background:
  Given user goes to "https://test.urbanicfarm.com/"
  And User clicks login button on the home page
  And User enters a valid email,password and clicks the login button

  #And User closes the alert
  When the user clicks account name
  And user clicks on Delivery & Pick up settings
  And user clicks Buyer Picks Up checkbox
  And user verifies Your available hours is visible
  And user verifies Your available hours is functional

  @UI
  @US055-TC01
  Scenario:
  And user clicks on start time and enter a valid time in Buyer Pick Up
  And user clicks on end time and enter a valid time in Buyer Pick Up
  Then user clicks on update button
  Then user verifies the valid message "Your delivery settings have been successfully updated"

  @UI
  @US055-TC02
  Scenario:
    And user clicks on start time and enter an invalid time in Buyer Pick Up
    And user clicks on end time and enter an invalid time in Buyer Pick Up
    Then user clicks on update button
    Then user verifies the valid message "Start time cannot be greater than end time at the Buyer picks up field."

