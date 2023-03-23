#As a user, when i should add new promo code then I Should be able to see promo code information
# in the correct schema and columns in DB
# Database
# Correct infos need to be seen in the correct columns.
# I should see user informations in the correct columns, eg : id;1905 name; burakPromo

Feature: US126

  @DB
  Scenario: TC001
    Given user connect to the database
    And user send the query to the promo code table
    And user send query for code colum om the promo code table
