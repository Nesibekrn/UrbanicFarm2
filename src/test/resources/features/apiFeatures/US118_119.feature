Feature: As a user, I should be able to complete an event and  should be able to delete an event

  @US118
  Scenario: User I should be able to complete an event and should be able to delete an event
    Given User logs in API for delete event
    Then User creat an address
    When User create an event
    Then User complete an event
    Then User verifies the status complete
    And User verifies success is true complete
    Then User delete an event
    Then User verifies the status delete
    And User verifies success is true delete


