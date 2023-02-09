# HomePage US014 User should be able to perform various operations on homepa

# Ugur
Feature: US014_001, The "Whats Near You, Post Your Goods" heading under the "Reduce waste,strengthen your Community"
  heading should be clickable
  Background:

    Given user goes to "https://test.urbanicfarm.com/"
  @UI
  @US014
  Scenario: The "Whats Near You,Post Your Goods" heading should be clickable

    And user goes  the "Reduce waste,strengthen your community" heading
    And user waits 2 second
    Then user verifies  the "Whats Near You,Post Your Goods" heading is clickable