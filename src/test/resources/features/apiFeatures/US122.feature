@US122
Feature: As a user, I should be able to get weekly order list

    Scenario: User gets weekly order list
    Given User login with US122Email and password
    Then User gets the weekly order list
    Then User checks API Status Code
