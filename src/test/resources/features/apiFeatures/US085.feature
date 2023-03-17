#Account
#User should be able to change user information.
#https://test.urbanicfarm.com/api/account/change/phone
#Details on the swagger document.
  @US085
  Feature: US085 As a user, I should be able to change user information.
    Scenario: As a user, I should be able to change user information
      Given User goes to api for change account info
      When User change phone number as 956224488
      Then User verify new phone number as "956224488"