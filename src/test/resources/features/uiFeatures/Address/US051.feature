#Address edit and remove buttons should be visible in the Delivery Address section
 #The address should be corrected with the edit button and the process should be completed with the submit button.
 #After clicking Submit, "Your Address successfully updated" alert should appear.
 #When the Remove button is clicked, the "Are you sure to delete the address?" screen should be displayed.
 #Yes/No options should appear.
 #One of the Yes/No options should be selected.
 #No option should cancel the operation
 #Address should be removed when Yes option is selected
 #"Address deleted" alert should appear as a result of the operation.

Feature: As a user, after entering valid information, I should be able to perform various actions in the Address section

  Background:

    Given user goes to "https://test.urbanicfarm.com/"
    And user has entered valid login information and has logged in
    And User clicks Account Name Navbar
    And User clicks Address Button

  @UI
  @US051
  Scenario: User goes to address page
    Then User click delivery address button
    Given User add new address as "paris" if it is not exist
    When user clicks the edit button next to the desired delivery address
    Then User updates zipcode "25462"
    And  user clicks the submit button and get alert message "Your Address successfully updated"
    When user click remove button  and see yes and No page
    And User click yes button and get alert message "Address deleted"













