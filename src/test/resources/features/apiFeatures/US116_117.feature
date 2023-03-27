Feature:  As a user, I should be able to update an event

  @API
  @US116_117
  Scenario:
    Given User logs in with Api
    When User gets all my events info
    And User update an event
#      | 890     | Home      |
#      | 908     | Online    |
#      | 954     | Barcelona |
    Then User verifies status code is 200
    And User verifies success is true for Event
    Then User cancel an event
    Then User verifies status code is 200
