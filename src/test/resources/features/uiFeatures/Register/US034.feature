Feature: US034

  @UI
  @US034
  Scenario: US034_TC001
    Given User goes to "https://test.urbanicfarm.com/"
    When user clicks on registration button on the navbar
    And user fills out the registration form
    And user clicks on Register button
    Then user verifies following elements are visible
      | Welcome to Urbanic Farm!      |
      | What would you like to do?    |
      | Buy local food                |
      | Sell local food               |
      | Provide service for gardening |
      | I will do all                 |
    And user verifies following elements are clickable
      | Buy local food                |
      | Sell local food               |
      | Provide service for gardening |
      | I will do all                 |
    And user verifies Welcome to Urbanic Farm is visible
