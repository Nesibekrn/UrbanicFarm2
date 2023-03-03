#Delivery type-Seller delivers the products
#All menus in the relevant area should be functional and appropriate options should be selected.
#Free Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#Minimum Order Amount For Free Delivery($) should be 0-10000. Alert should be seen on different selections
#Per Mile Cost ($) should be 0-5. Alert should be seen in different selections
#Maximum Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#An appropriate option must be selected from the Estimated Delivery Time menu
#A number must be entered in the Up to (mile) menu
#Your delivery settings have been succesfully updated alert should appear

@UI
@US056
Feature:

  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    When  User clicks the login link
    When User enters valid email address & password & clicks the login button
    When User clicks Account Name Navbar
    Then user clicks on delivery & pick up settings
    And  user verifies All menus in the relevant area are functional and appropriate options are selected

  @UI
  @US056_TC01
  Scenario: US056_TC01
    When user leaves empty boxes on the seller delivers on the products and verifies the alert.
    |freeDeliveryRange| 500 |
    |minFreeDeliveryOrder| 600 |
    |perMileCost         | 3   |
    |providingDistance   | 200 |
    |estimatedDeliveryTime| 0  |


  @UI
  @US056_TC02
  Scenario: US056_TC02
    When user enters invalid value user must see different alert
      | -1    | Value must be greater than or equal to 0. |
      | -0.01 | Value must be greater than or equal to 0. |
      | 1  | Value must be less than or equal to  |
      | 0.001 | Value must be less than or equal to       |
    When user enters invalid value to up to mile box user must see different alert
      | -1    | Value must be greater than or equal to 0. |
      | -0.01 | Value must be greater than or equal to 0. |
    And user enters valid value and see "Your delivery settings have been successfully updated"

