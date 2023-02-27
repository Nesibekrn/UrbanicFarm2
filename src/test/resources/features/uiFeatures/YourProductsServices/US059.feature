@UI
@DB
@US059
Feature:US059
  Background:
    Given User login as Seller to Address link
    When User "seller" add new address if it is not exist as "NE4 8UH"
    And User goes to Your products-service

  @UI
  @DB
  @US059_TC01
  Scenario: US059_TC01
    And User click on random Hubs2
    When Product Name, Price, Stock, Unit, Organic, Trade information added products should be displayed.
    Then One of the Approved, In-Review, Rejected options for each product should be visible on the file.
    Then In-Review should be visible on the added product2.
    Then User approve last added product from database
    Then Approved should be visible on the added product2.
    Then User sees the product on WelcomePage with organic tag if it is.
    And User sees the product with Avaliable for Trade link.

  @UI
  @DB
  @US059_TC02
  Scenario: US059_TC02
    When User clicks previous hub
    Then It should be possible to click on the product name on the file related to the previously added product2.
    When The product name is clicked, the update-delete page is displayed.
    When Product information should be able to be changed on this page
    When the update option is clicked after the necessary corrections, (.....) has been succesfully updated alert should be displayed2.
    When the Delete button is clicked, yes- no options should appear.
    Then Yes-No options should appear.
    Then No option should cancel the operation2

  @UI
  @DB
  @US059_TC03
  Scenario: US059_TC03
    When User clicks previous hub
    Then It should be possible to click on the product name on the file related to the previously added product2.
    When The product name is clicked, the update-delete page is displayed.
    When the Delete button is clicked, yes- no options should appear.
    Then Yes-No options should appear.
    When Yes option is selected, the product should be removed from the page2.