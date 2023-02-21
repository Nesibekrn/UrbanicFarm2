Feature: I should be able to perform various actions in the Delivery & Pick up settings section

  @UI
  @US_054
  Scenario: US054-TC01
    Given user goes to "https://test.urbanicfarm.com/"
    And User clicks login button on the home page
    And User enters a valid email "us050Email"
    And user enters valid password "us050Password"
    Then the user clicks login button on the login page

    When user clicks on name Nilanka beside the logout button
    And user verifies that current url is "https://test.urbanicfarm.com/account/home"
    And user clicks on Delivery & Pick up settings
    And user verifies that current url is "https://test.urbanicfarm.com/account/delivery"
    And user clicks on Buyer picks up on the vine option
    And user verifies Your available hours functional
    And user verifies Your available hours visible
    And user clicks on start time and enter the time
    And user clicks on end time and enter the time
    Then user clicks on update button
    Then user verifies the message "Your delivery settings have been successfully updated"