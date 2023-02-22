@UI
Feature: Apply promo code and complete payment
  Background:  User goes to cartpage with token
    Given User on the Cart page
  Scenario Outline: Apply valid promo code and complete payment
    And User should see total amount
    When User enter a valid promo code in the "<Enter promo code>" menu
    And User click the apply button
    Then User should update total Amount
    And the promo code should be applied correctly "<Enter promo code>"
    Examples:
      | Enter promo code |
      | dolar10          |
      | dolar20          |
      | percentage10     |
      | percentage20     |
      | percentage30     |

  Scenario: Apply invalid promo code and see error message
    When User enter an invalid promo code in the "<Enter promo code>" menu after then click the "Apply" button and see an alert message saying
      |dolar23      | Invalid Promo-code.No such promo code is defined |
      | dolar30    | You can't apply this promocode due to greater or equal than your total amount|
