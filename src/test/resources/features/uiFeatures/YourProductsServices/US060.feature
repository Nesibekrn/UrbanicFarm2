Feature:US060_TC001_As a user, after entering valid information, I should be able to perform various actions
        in the Your products/services section

  Background: User goes to URL
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US060
  Scenario: To check if GO BACK button working properly in Module of Your Products/Services
    And User clicks the login link
    Then User enters registered email address & password & clicks the login button
    Then User clicks Account Name Navbar link by menu
    Then User clicks Address link by menu
    Then User clicks Add New Address
    Then User enters Postal Code to creat new addres
    Then User clicks delivery & sales addresses and clicks to Submit button
    Then User clicks Your Products Services in menu
    And User clicks to Vegetables and fruits button
    When User clicks Go back button
    Then user verifies if Go back button is working
    And User clicks Address link by menu
    When User deletes existing address


