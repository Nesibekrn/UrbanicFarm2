Feature: US026_Blog should be clickable and relevant page should be visible
  @UI
  @US026
  Scenario: US026_TC01
    Given user goes to "https://test.urbanicfarm.com/"
    When user clicks to Blog button
    Then user verifies relevant page is "https://urbanicfarm.com/blog/"
    
