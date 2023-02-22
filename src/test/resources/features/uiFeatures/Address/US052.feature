@UI
@US052
Feature: US052

  Background:
    Given User goes to "https://test.urbanicfarm.com"
    When User clicks login link
    And User enters a valid email,password and clicks the login button
    And User clicks "Seller" username
    And user clicks the Address button on left column
    And user clicks the My Sales Address

  @UI
  @US052-TC001
    Scenario: TC001
    #Then user clicks the Add New Address
    #Then user clicks the Search Places box
    #Then user writes "Netherlands" in the box, sees addresses and select an address
    #Then user marks the Mark as sales address section on the page that opens
    #Then user clicks Submit button on Address section
    And user sees that the Edit button is clickable
    And user clicks the cancel button
    And user sees that the Remove button is clickable
    And user clicks the No button

  @UI
  @US052-TC002
  Scenario: TC002
    And user clicks the Edit button
    And user change Zip number and clicks Submit button
    When user verifies the alert "Your Address successfully updated" should appear

  @UI
  @US052-TC003
  Scenario: TC002
    When user clicks the Remove button
    And user "Are you sure to delete the address?" screen should be displayed
    And user should display "Yes/No" options
    And user selects one of the "Yes/No" options
    Then user verifies that the address could not be removed

    #adres varken kontrol et

  #precondition can be used
  #if condition kullanılabilir






  #add new address ekle