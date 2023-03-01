Feature: Welcome Page


  Background: Login in
    Given User goes to "basket" as seller



  @UI
  @US066

  Scenario: As a user, after entering valid information,
  I should be able to perform various actions in the Welcome Page
    When User login should click on Basket button
    And User click on increase Quantity plus button
    And Are you sure you want to delete the product? warning should appear
    Then User clicks on no then yes
    Then Total should change in product wraps
    And Final Total should change in product wraps


