Feature: Login with zip code
  @UI
    @US033
Scenario:
Given user goes to "https://test.urbanicfarm.com/"
  And user clicks on "Register" button
  When user send to zip code on the register
  Then zip code text suppose to be red
  When user click on enter
  Then user suppose to see "Please match the requested format." test

