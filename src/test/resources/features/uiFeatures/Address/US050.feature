# HomePage US050 As a user, after entering valid information, I should be able to perform various actions
# in the Address section



# Vural
  # Non Selected Address
Feature: US050_TC_001, As a user, after entering valid information, I should be able to perform various actions
  in the Address section
  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    And user logins to website
    When User clicks Account Name Navbar
    Then User clicks Address Button
    And User clicks Add New Address Button
    And User writes Paris in the box, sees addresses and select an address
    And User clicks Submit Button on Address Section
    And User verifies Alert Message "Your address has been successfully updated" is displayed

  @UI
  @US050
  Scenario: As a user, after entering valid information, I should be able to perform various actions in the Address section
    Then User verifies that "You have not set your sales address yet. Please select one of your unselected addresses." alert is displayed on My Sales Address Section
    Then User verifies that the address Edit and Remove buttons should be operational in the Unselected Address section
    Then User clicks Edit Button and changes Zip Number and clicks Submit Button
    Then User verifies that the alert "Your address has been successfully updated" should appear
    Then User verifies that Remove Button is clickable
    Then User verifies that "Are you sure you want to delete the address?" alert is displayed
    Then User verifies that Yes-No options must be selected
    Then User verifies that "No" option should cancel the action
    Then User verifies that "Yes" option should remove the address
    Then User verifies that "Address deleted" warning should appear
