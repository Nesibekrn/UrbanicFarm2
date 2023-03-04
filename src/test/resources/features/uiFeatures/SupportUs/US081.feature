Feature: As a user, I should be able to perform various operations on the Support us page

Background: Login
  Given User goes to Welcome Page

  @UI
  @US081
    Scenario:
    When User clicks on Support the local food movement
    And User verifies "https://wefunder.com/urbanicfarm" is displayed
    And User clicks Investor Panel button
    And User verifies Show more button is displayed
    And User clicks on Invest box and writes a number
    And User clicks on Invest button
    Then User verifies reservation amount is displayed




