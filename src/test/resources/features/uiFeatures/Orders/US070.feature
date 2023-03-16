Feature: As a user, after entering valid information, I should be able to perform various actions in the Welcome Page

  Background: Login
    Given User login as "sellerTokenOmer" to "home"

  @UI
  @US070
  Scenario:
    And User clicks add to cart button
    And User verifies the "added to your basket!" warning is displayed
    When User clicks on the sellers account
    And user verifies goes to "https://test.urbanicfarm.com/point/" page
    And User selects any order
    And User verifies the "added to your basket!" warning is displayed
    And User clicks "view larger map"
    And User verifies map opened on other page