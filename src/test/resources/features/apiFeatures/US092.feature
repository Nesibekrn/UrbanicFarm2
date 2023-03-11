Feature: US_092 As a user, I should be able to change availability for seller delivers the products.
@US092
  Scenario: US_092 As a user, I should be able to change availability for seller delivers the products.
    Given User logs in with API for seller delivers
    When User changes availability for seller delivers the products
      | deliveryType          | SELLER_DELIVERY     |
      | freeDeliveryRange     | 5                   |
      | maxDeliveryRange      | 4                   |
      | minFreeDeliveryOrder  | 5                   |
      | perMileCost           | 5                   |
      | estimatedDeliveryTime | 60_3                |
    Then User verifies that success is true