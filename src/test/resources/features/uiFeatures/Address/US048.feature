
  @UI
  @US48
  Feature: As a user, after entering valid information,
    I should be able to perform various actions in the Address section

    Background:
      Given User goes to "https://test.urbanicfarm.com"

      Scenario: US48-TC01

        Given User goes to login button and click
        When User goes to e-mail box and write address
        Then User goes to password box and writes password
        And User clicks submit button
        And User clicks Sell-Share-Trade button
        And User click address button
        And User click Add New Addres button
        And User verify Serach Places box
        And User click first Cancel button


     Scenario: US48-TC02
       Given User goes to login button and click
       When User goes to e-mail box and write address
       Then User goes to password box and writes password
       And User clicks submit button
       And User clicks Sell-Share-Trade button
       And User click address button
       And User click Add New Addres button
       And User wirtes Paris in the box, sees addresses and select an address
       Then User verify address information entry screen
       And User clicks second cancel button
        And User return to the previous page and verify

