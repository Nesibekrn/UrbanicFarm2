Feature: US022 Privacy Policy should be clickable and relevant page should be visible
@UI
  Scenario: TC001 Privacy Policy should be clickable and relevant page should be visible

    Given the user goes to "https://test.urbanicfarm.com/".
    And the user scrolls down the home page.
    And the user clicks the Privacy Policy.
   Then the user verifies the Privacy Policy is enabled.
    Then the user verifies the page is "https://test.urbanicfarm.com/privacy-policy".
   And the user navigate to current.