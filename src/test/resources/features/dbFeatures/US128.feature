Feature: As a user, when i should log in to my account then I Should be able to see all events that I created .
  I should able to connect DB and see all events in correct schema and columns in DB

  @UI
  @DB
  @US128
  Scenario:
    And User login as "sellerTokenOmer" to "account/events-i-organize"
    And User clicks My Completed Events tab
    Then user verifies following column names are present in "event" table
      | owner_id  |
      | title     |
      | is_active |
    Then User verifies if all events are in correct schema and columns in DB



#   As a user, when i should log in to my account then I Should be able to see all events that I created .
#    Then I should able to connect DB and see all events in correct schema and columns in DB