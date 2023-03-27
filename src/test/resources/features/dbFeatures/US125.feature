#As a user, when i should add new product then I Should be able to see
# new product  in the correct  schema and columns in DB
  Feature: Correct infos need to be seen in the correct columns.
    I should see user informations in the correct columns, eg : TOMATO
    @DB
  Scenario:
#      Given connect to database and see columns in the product table

      Given  Connect Database
      And see all column names by sending column names query
      And check product columns name by sending data table
      |unique_name|
      |title|
      |hub_title|
      And find unique name from unique_name column by using data table
      |TOMATO_ROMAN|
      |CORN |
      |POTATO|
      |MILK  |
     |SUNFLOWER|

