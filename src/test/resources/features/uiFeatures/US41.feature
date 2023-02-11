@US41
  @UI
  Feature: As a user, after entering valid information,
    I should be able to perform various operations on the Sale-Pay-Trade page.

    Background:
      Given User goes to "https://test.urbanicfarm.com"

    Scenario:

      Given User goes to login button and click
      When User goes to e-mail box and write address
      Then User goes to password box and writes password
      And User clicks submit button
      And User clicks Sell-Share-Trade button
      And User clicks Sceduled delivery
      And User verify relevant page text: "Enter your zip code to see if we deliver in your area."
      And User closes the relevant page