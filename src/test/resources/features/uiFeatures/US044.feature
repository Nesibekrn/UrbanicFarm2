@UI
@US044
Feature: US044-As a user, after entering valid information, I should be able to perform various operations on the Sale-Pay-Trade page.
  Scenario: US044-TC01 Logut should be clickable and relevant page should be visible
    Given User goes to "https://test.urbanicfarm.com/"
    And User click the login link
    When User enters a valid email,password and clicks the login button
    Then User verifies logout botton is clickable
    Then User verifies the url is "https://test.urbanicfarm.com/"