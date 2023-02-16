Feature: As a user, after entering valid information, I should be able to perform various actions in the Address section
  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    And user logins to website
    When User clicks Account Name Navbar
    Then User clicks Address Button
    And User clicks Add New Address Button
    And User writes Paris in the box, sees addresses and select an address
    And User clicks Submit Button on Address Section
    And User verifies Alert Message "Your address has been successfully updated" is displayed