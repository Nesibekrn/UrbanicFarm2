#Orders option should be clickable
#Clicking on Orders should display the Your Orders(Orders List) page.
#Any order must be selected
#The view order details button must be functional.
#When the View order details button is clicked, the Order Details page should be displayed.
#The Order summary and Order contents fields should be visible on the Order Details page.
#Seller page button should be functional
#Seller page should redirect to correct page when clicked
#Seller address button should be functional
#Seller page view should give correct result with larger map
Feature:As a user, after entering valid information,
  I should be able to perform various actions in the Orderds section
  Background:
  @US062
  @UI
  Scenario:
    Given the user goes to "https://test.urbanicfarm.com/".
    When the user clicks login module button
    Then the user verifies the page is "https://test.urbanicfarm.com/auth/login".
    And the user fill out valid email in username text box
    And the user clicks login button on the login page
    Then the user verifies account name is displayed
    And the user clicks account name
    Then the user verifies page is "https://test.urbanicfarm.com/account/home"
    And The user clicks orders option
    Then The user verifies orders tab is enabled
    Then  The orders page should be displayed
    And Orders list should be displayed
    When The user clicks view order details
    Then The Order Details text should be displayed on the Order Details page
    Then The Order summary should be displayed on the Order Details page
    Then The Order contents fields should be visible on the Order Details page
    And The Seller page link should be enabled
    And Seller page should redirect to correct page when click back


  @US062
  @UI
  Scenario:US062_TC001
