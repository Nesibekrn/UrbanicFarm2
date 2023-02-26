Feature: US063_TC001_As a user, after entering valid information, I should be able to perform various
         actions in the Welcome Page

  Background: User goes to URL
    Given User goes to Welcome Page

  @UI
  @US063
    Scenario: User checks if Several Buttons which are mentioned in Acceptance Criteria are functional
      Then User verifies if Welcome Page appears
      And User verifies if What are you looking for box is functional
      And User verifies if Search miles box is functional
      And User verifies if Catergories box is functional
      And User verifies if Search only in organic produce is functional
      And User verifies if Search menus box is functional
     # And User clicks Search menus box
      Then User verifies if Price, Delivery type, Unit type options are visible
      When User selects any option of dropdown menu by What are you looking for box
      And User selects any option of dropdown menu by Search miles box
      And User selects any option of dropdown menu by Catergories box
      And User clicks Search only in organic produce toggle button
      And User clicks Search menus box
      Then User selects Price upto options and clicks related of Delivery type checkbox and Unit type checkbox
      And User clicks Search button
      Then User verifies if correct results are appearing


#  After entering the buyer user name/buyer password, the Welcome Page should appear
#  What are you looking for,Search in miles, Categories, Search only in organic produce, Search menus should be functional
#  When the Box is clicked, Price, Delivery type, Unit type options should be seen.
#  What are you looking for,Search in miles, Categories, Search only in organic produce, Search menus should give correct results