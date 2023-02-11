Feature: US43 As a user, after entering valid information, I should be able to
  perform various operations on the Sale-Pay-Trade page.

  Background:
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US043
  Scenario:
    When User clicks login link
    Then User enters a valid email,password and clicks the login button
    Then User clicks "Cristian" username
    Then User verifies the username is visible
    Then User verifies the url of the account name page