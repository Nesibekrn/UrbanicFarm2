Feature: US096_TC001_As a user, I should be able to get the hub information.

  @US096
  Scenario: To check getting the HUB information in API
    Given User logs in as seller with API
    Then User gets Hub info
    Then user verifies the status code is 200