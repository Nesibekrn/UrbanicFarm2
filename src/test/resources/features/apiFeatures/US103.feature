#US_103, As a user, I should be able to get basket details.
# Products & Services
# User should be able to get basket details.
# https://test.urbanicfarm.com/api/public/getBasketDetails
# Details on the swagger document.
#sevinc

Feature: US_103, As a user, I should be able to get basket details.
  Scenario: TC_001 I should be able to get basket details.
    Given the user connects to the "string" api
    And the user connects to the getBasketDetails api
    Then the user verifies that the status code is 200