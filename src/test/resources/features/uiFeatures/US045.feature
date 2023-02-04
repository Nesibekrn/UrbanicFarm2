Feature: US045

  Background:
    Given user goes to "https://test.urbanicfarm.com"
    When User clicks Sell-Share-Trade button
  Scenario:US045_TC01
    And  User clicks login button
    And  User goes to email box and writes email
    And User goes to password box and writes password
    Then User click login page
    And  User clicks notification button
    Then  User verify relevant notifications visibility