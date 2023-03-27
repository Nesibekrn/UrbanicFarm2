Feature: US120-121 As a user, I should be able to create, get scheduled order
  Scenario:

    Given User logs in with API for scheduled order
    When  User create a new scheduled order
    Then  User verifies that response is as expected
    When  User get scheduled order list
    Then  User verifies that response is as expected for get scheduled order