Feature: US069 As a user, after entering valid information, I should be able to perform various actions in the Welcome Page

  @US069
  @UI
  Scenario: US069_TC01
    Given User login as "sellerNesibe" to "account/address"
    Then User "seller" add new address if it is not exist as "Ankara"
    Then User add a new product if it is not exist
    And User login as "buyerNesibe" to "account/address"
    When User "buyer" add new address if it is not exist as "Ankara Ulus"
    Then User goes to Welcome Page
    And User clicks the Notification button
    And User clicks Mark All As Read link
    And User verifies that number on Notification Icon is 0
    And User clicks Add to Cart of last product
    Then User clicks Number of Cart button
    And User clicks the Proceed To Checkout button
    And User verifies the next page opened.
    And User clicks Next-Previous button and verifies related page opened.
    And User clicks Go To Payment button and verifies related page opened.
    Then User enters Payment Information
    And User verifies that "Check out captured. You can close this tab now." alert is visible
    And User verifies that "Payment successful" text is visible
    And User clicks Rate button and verifies related page opened.
    And User clicks Order detail button and verifies related page opened.
    And User verifies that Orders status is "In Progress"
    And User clicks the Notification button
    And User verifies that number on Notification Icon is 1
    And User verifies that Orders status is "In Progress"








