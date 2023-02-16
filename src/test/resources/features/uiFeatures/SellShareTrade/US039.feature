Feature: US039_TC_001_About Us should be clickable and Cart page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US039
  Scenario: To check About Us if it is clickable and visible when user logins with valid email and password
    And User click the login link
    Then User enter valid email address & password & clicks the login button
    Then User checks the About Us Link is clickable
    Then User clicks the About Us Link
    Then User verifies if About Us page is  visible