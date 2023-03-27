@aynur
@US102
Feature: As a user, I should be able to get all requested products' information.

  Scenario:
    Given user logs in with api for get all product request
    Given user can get all requested products' information
    Then user verifies the all requested product status code is 200
    Then user verifies the all requested product response
