Feature: As a user, I should be able to receive all my events info.






  @API
  @US109

    #this should be US109

  Scenario: US110_1 Receive all my events info.
    And User logs in as seller with API service
    Then User verifies all my events info is are correct
    Then User verifies status code is 200