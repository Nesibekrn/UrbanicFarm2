Feature: US023 Terms Of Service should be clickable and relevant page should be visible
  @UI
  Scenario: TC001_ Terms Of Service should be clickable and relevant page should be visible

    Given the user goes to "https://test.urbanicfarm.com/".
    And the user scrolls down the home page.
    And the user clicks the Terms Of Service.
    Then the user verifies the Terms Of Service is enabled.
    Then the user verifies the page is "https://test.urbanicfarm.com/terms-of-service".
    When the user navigate to current.