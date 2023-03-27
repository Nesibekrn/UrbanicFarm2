Feature:US112_TC001_As a user, I should be able to register an existing event

  @API
  @US112_113_114
  Scenario: To check register in existing event
    Given User logs in as Seller with API
    And User creates Address
    And User creates Event
    And User gets Register
    Then User verifies success message is true
    Then User verifies if status code is 200 on Event
    And User Go To Payment
    Then User verifies success message is true
    Then User verifies if status code is 200 on Event
    When User checks the Order Status
    Then User verifies success message is true
    Then User verifies if status code is 200 on Event
    And User deletes created event
    And User deletes created address



#  Events
#  User should be able to register an existing event
#  https://test.urbanicfarm.com/api/account/event/register
#  Details on the swagger document.

#  Events
#  User should be able to go to payment.
#  https://test.urbanicfarm.com/api/account/event/attendance/gotopayment
#  Details on the swagger document.