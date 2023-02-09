Feature: US04_Explore should be clickable and relevant page should be visible
  @UI
    @US05
  Scenario: US05_TC01
    Given user goes to "https://test.urbanicfarm.com/"
    When user clicks to About Us button
    Then user verifies relevant page is "https://test.urbanicfarm.com/about"
