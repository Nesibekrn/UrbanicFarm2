Feature: US040_TC_001_Contact Us should be clickable and Cart page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US040
  Scenario: To check Contact Us if it is clickable and visible when user logins with valid email and password
    And User clicks the login link
    Then User enters valid email address & password & clicks the login button
    Then User checks the Contact Us Link is clickable
    Then User clicks the Contact Us Link
    Then User verifies if Contact Us page is  visible