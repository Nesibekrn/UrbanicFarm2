Feature: Us129 As a user, when i should log in to my account then I Should be able to send a message.
I should able to connect DB and see message that I send in correct schema and columns in DB

  @UI
    @DB
    @US129
  Scenario:
    Given User login as "sellerTokenOmer" to "home"
    And User sends a message from UI
    And user verifies following column names are present in "message" table
      | owner_id        |
      | content         |
      | conversation_id |
    When User gets message data from Data Base
    Then User verifies sended message is exists in Data Base