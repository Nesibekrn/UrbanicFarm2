Feature: As a user, I should be able to get all events' details.

  @US108
  Scenario: User checks getting all events details.
    Given User goes to API as Seller
    And User gets all Events Details
    Then User verifies if status code is 200
    Then User verifies success is True

#  Events
#  User should be able to get all events' details.
#  https://test.urbanicfarm.com/api/public/getAllEvents
#  Details on the swagger document.