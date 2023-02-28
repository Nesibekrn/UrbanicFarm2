Feature:As a user, after entering valid information,
  I should be able to perform various actions in the Orderds section

  Background:

    And the user fill out valid email in username text box
    Then the user verifies account name is displayed
    And the user clicks account name
    Then the user verifies page is "https://test.urbanicfarm.com/account/home"
    And The user clicks orders option
    Then The user verifies orders tab is enabled
    Then  The orders page should be displayed
    And Orders list should be displayed
    When The user clicks view order details

  @US062
  @UI
  Scenario: US062_TC001
    Then The Order Details text should be displayed on the Order Details page
    Then The Order summary should be displayed on the Order Details page
    Then The Order contents fields should be visible on the Order Details page

  @UI
  Scenario: US062_TC002
    And The Seller page link should be enabled
    And The Seller page should be redirected to correct page when click back
    Then The user clicks Seller address is displayed
    Then The user verifies seller address is correct