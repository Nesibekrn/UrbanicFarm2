Feature:

  Background: User goes to URL
    Given User goes to "https://test.urbanicfarm.com"


  @UI
  @US060
  Scenario:
    And User clicks the login link
    Then User enters valid email address & password & clicks the login button
    Then User clicks Address link by menu
    Then User clicks My Sales Address
    Then User clicks Add New Address
    Then User enters Postal Code to creat new addres
    Then User clicks delivery & sales addresses and clicks to Submit button
    Then User selects new cateogry in Add new product/service part and clicks to  Add button
    And User clicks to Vegetables and fruits button
    When User clicks Go back button
    Then user verifies ıf Go back button is working


