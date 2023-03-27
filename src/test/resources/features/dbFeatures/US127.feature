Feature: US127 As a user, when i should add new event then I Should be able to see event information in the correct  schema and columns in DB

  @DB
  Scenario:
    Given User add a new event from API

    When user verifies following column names are present in "event" table
      | title          |
      | duration       |
      | attendee_limit |

    Then user verifies the added event exist