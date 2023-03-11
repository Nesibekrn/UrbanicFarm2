Feature: As a user, I should be able to receive all products' details
  Scenario: User should be able to receive all products details


    Then user verifies the list of all product
    Then user verifies the response status code is 200
    And user verifies success is true
  #  And user verifies all products are visible