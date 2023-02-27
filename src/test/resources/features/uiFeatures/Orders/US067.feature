#Welcome Page-Cart
#Order statuses must be seen in mutual buyer-seller accounts
#Your order placed messages should be seen in the basket in the buyer account, and You have a new order messages in the seller account.
#Seller, order status should be updated in cart
#As a result of updating the order status, the order status should be updated in the buyer's account.
#Mark all as read button and X button must be functional on buyer and seller accounts
#Mark all as read button and X button should give correct results in buyer and seller accounts.
Feature: US067

  @UI
  @US067
  Scenario: US067-TC01
    Given User login as "sellerNesibe" to "account/address"
    Then User "seller" add new address if it is not exist as "Ankara"
    Then User add a new product if it is not exist
    And User login as "buyerNesibe" to "account/address"
    When User "buyer" add new address if it is not exist as "Ankara Ulus"
    And User give an order from Seller
    And User clicks Account Name Navbar
    And User clicks Orders option
    And User -Buyer- verifies that Orders status is "In Progress"
    Then User login as "sellerNesibe" to "account/sold-items"
    When User -Seller- changes Orders status "On Delivery"
    And User login as "buyerNesibe" to "account/orders"
    And User -Buyer- verifies that new Orders status is "On Delivery"
    Then User login as "sellerNesibe" to "account/sold-items"
    When User -Seller- changes Orders status "Completed"
    And User login as "buyerNesibe" to "account/orders"
    And User -Buyer- verifies that Orders status is "Completed"
    When User "Buyer" clicks Notification icon
    And User verifies that "Your Order is Placed" message is displayed.
    Then User "Buyer" verifies Mark all as read button and X button are functional
    And User "Buyer" verifies that correct result is occure after clicking Mark all as read button
    And User "Buyer" verifies that correct result is occure after clicking X button
    Then User login as "sellerNesibe" to ""
    When User "Seller" clicks Notification icon
    And User verifies that "You Have a New Order" message is displayed.
    Then User "Seller" verifies Mark all as read button and X button are functional
    And User "Seller" verifies that correct result is occure after clicking Mark all as read button
    And User "Seller" verifies that correct result is occure after clicking X button