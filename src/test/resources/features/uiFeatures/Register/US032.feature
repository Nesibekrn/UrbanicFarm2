Feature: US032, User should be able to check valid and invalid passwords.
  Background:
    Given User goes to "https://test.urbanicfarm.com/"
    And user clicks on registration button on the navbar
    And user enter first name box
    And user enter last name box
    And user enter valid email address on the registration form

  @UI
  @US032
  Scenario: US032,TC001_User should be able to check valid and invalid passwords.
    Given user enters invalid password
    Then user verifies that the alert is displayed on the Registration Page

  Scenario: US032,TC002
    Given user enters valid password
    When user enter invalid confirm password
    Then user verifies that the "Passwords Don't Match" alert appears
    Given user enters valid password
    And user enters valid confirm password