Feature: US04_Explore should be clickable and relevant page should be visible
  @UI
    @US04
  Scenario: US04_TC01
    Given user goes to "https://test.urbanicfarm.com/"
    When user clicks to explore button
    Then user verifies relavent page is "https://test.urbanicfarm.com/explore"
