Feature: US_006_TC_001_Contact Us should be clickable and Contact Us page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com/"

  @UI
  @US006
  Scenario: To check if Contact Us link is clickable and passing to Contact Us page when it clicked
    And User checks the Contact Us button is clickable
    Then User clicks Contact Us button
    Then User verifies if Contact Us page is visible