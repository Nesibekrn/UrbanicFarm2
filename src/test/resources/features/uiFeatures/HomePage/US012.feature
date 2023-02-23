@US12
@UI
Feature: User should be able to perform various operations on homepage


    Background:
           Given User goes to "https://test.urbanicfarm.com"

    Scenario:

      Given User goes to login button and click
      When User goes to e mail box and write address
      Then User goes to password box and writes password
      And User clicks Submit button
      And User clicks Sell-Share-Trade button
      And User verify current URL
      And User closes the browser