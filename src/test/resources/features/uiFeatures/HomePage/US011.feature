Feature:

  @UI
  @US11
    Scenario: Backyard gardeners and farmers join the Movement For Free! The "register now" button at the bottom should be clickable
    Given User goes to home page
    Then User assert register now button is clickable
    When User clicks on register now button
    Then User verified the url is "https://test.urbanicfarm.com/auth/register"