Feature: US046_TC_001_Cart should be clickable and Cart page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US046
  Scenario: To check Cart if it is clickable and visible when user logins with valid email and password
    And User clicks the login link
    Then User enters valid email address & password & clicks the login button
    Then User checks the Cart button is clickable
    Then User clicks the Cart button
    Then User verifies if Cart page is  visible
