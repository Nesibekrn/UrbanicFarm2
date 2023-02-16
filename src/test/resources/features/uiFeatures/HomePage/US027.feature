Feature: US027_TC_001_Facebook icon should be clickable and relevant page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US027
  Scenario: To check if Facebook link is clickable and passing to Facebook page when it clicked
    And User scrolls down to the Bottom End on the home page
    Then User checks the Facebook button is clickable
    Then User clicks the Facebook button
    Then User verifies if Facebook page is visible