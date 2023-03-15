Feature: As a user, I should be able to receive all my events info.


  @US110

  Scenario: US110_1 Receive all my events info.
    Given User logs in as seller with API
    Then User verifies all my events info is are correct
    Then User verifies status code is "200"