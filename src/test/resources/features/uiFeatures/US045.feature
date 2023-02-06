Feature: US045_TC_001_Notification should be clickable and Notification page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"
  @UI
  @US045
  Scenario: To check Notification  clickable and visible when user logins with valid email and password
    And User clicks the login link
    And User enters valid email address & password & clicks the login button
    When User clicks the Notification button
    Then User verifies Notification page is  visible
