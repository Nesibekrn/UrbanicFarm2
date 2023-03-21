# As a user, when i should sign up then Should be able to see new user information in the correct user schema and
# columns
#	Correct infos need to be seen in the correct columns.
#	I should see user informations in the correct columns, eg : email.

Feature: US123

  @UI
  @DB
  Scenario: TC001
    Given user goes to "https://test.urbanicfarm.com/"
    And user clicks on registration button on the navbar
    And user fills out the registration form
    And user clicks on Register button
    Then user verifies following column names are present in "user" table
      | email      |
      | first_name |
      | id         |
    And user verifies the added user exists