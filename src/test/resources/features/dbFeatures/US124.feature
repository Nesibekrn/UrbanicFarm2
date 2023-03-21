#Database
#
#Correct infos need to be seen in the correct columns.
#I should see user informations in the correct columns, eg : city
@DB
Feature:As a user, when i should add adress then I Should be able to see
  new adress  in the correct user schema and columns in DB

  Scenario:
    Given user adds an address from api
    When user verifies following column names are present in "address" table
    | title|
    | city|
    | state|
    Then user verifies the added address exists