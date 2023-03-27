Feature: As a user, I should be able to get user's attendance information.


  @API
  @US110

  Scenario:Getting user's user's attendance information.

    Then User get attendance info.
    Then User verifies the status code is 200