Feature:As a user, after entering valid information,
  I should be able to perform various actions in the Orderds section

Background:
  Given User goes to "https://test.urbanicfarm.com/"
  And User click the Login link
  Then User enter valid email address & password & clicks the login buttonu
  And the user clicks account name
  Then the user verifies page is "https://test.urbanicfarm.com/account/home"
   And The user clicks orders option
  Then The user verifies orders tab is enabled
  Then  The orders page should be displayed
  @US061_TC_01
  @UI
  Scenario: Product Name, Price, Stock, Unit, Image should be seen
  And Product name should be seen
  Then Product Price should be seen
  Then Product Stock should be seen
  Then Product Unit should be seen
  Then Product Image should be seen
   @US061_TC_02
   @UI
    Scenario: Rate the product, Rate The Seller buttons should be clickable
      And Rate the product button should be clickable
      And Rate the Seller button should be clickable
  @US061_TC_02
  @UI
      Scenario: When the Rate the product, Rate The Seller buttons are clicked, various actions should be performed on the screen that opens.
      And The Rate the product button are clicked various actions should be performed on the screen that open
      Then The Rate the Seller button are clicked various actions should be performed on the screen that open