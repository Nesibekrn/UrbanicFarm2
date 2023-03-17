#As a user, I should be able to get all orders.
# Orders
# User should be able to get all orders.
# https://test.urbanicfarm.com/api/account/order/get/myBuys
# Details on the swagger document.
  #Sevinc

Feature: US_104, As a user, I should be able to get all orders.
  Scenario: TC_001 I should be able to get all orders.
    Given the user connects to the "string" api
    And the user connects to the getmyBuys api
    And the user verifies buyer ids numbers more than one
    Then the user verifies that the status code is 200