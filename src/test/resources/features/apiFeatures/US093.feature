Feature: US093 As a user, I should be able to change availability for seller flexible delivery.

  @US093
  Scenario: US093 As a user, I should be able to change availability for seller flexible delivery.

    Given User login with API change flexible delivery
    When User change flexible delivery
      | deliveryType            | SELLER_FLEXIBLE |
      | freeDeliveryRange       | 3               |
      | maxDeliveryRange        | 3               |
      | minFreeDeliveryOrder    | 3               |
      | perMileCost             | 3               |
      | flexibleDeliveryOptions |                 |
      | deliveryBy              | 3               |
      | orderBegin              | 3               |
      | orderEnd                | 3               |
    Then User verifies flexible delivery success is true

