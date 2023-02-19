Feature:

  @UI
    @US10
  Scenario: Sell your produce should be clickable and relevant page should be visible
    Given User goes to home page
    Then  User assert sell your produce button is clickable
    When  User clicks on sell your produce button
    Then  User verified the url is "https://test.urbanicfarm.com/explore"