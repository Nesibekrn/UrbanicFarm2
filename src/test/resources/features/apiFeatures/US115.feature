Feature: As a user, I should be able to create an event

  @API
  @US115
  Scenario:
    Given User creates new Event
    Then User verifies that the status code is 200
    And User verifies the success is true



#Event
#User should be able to create an event.
#https://test.urbanicfarm.com/api/account/event/create
#Details on the swagger document.

