Feature: Account
@UI
  @US047
#  @buyer
  Scenario: As a user, after entering valid information, I should be able to perform various actions in the Account section.
    Given user login as Buyer
    * Account must be clickable
    When Account is clicked, Qr code, Full name, Email, Phone should be seen.
    * Copy button should be functional
    * Download button should be functional
    * Edit button should be clickable
    * Choose file button should be functional
    * The file should be selected when the choose file button is clicked.
    * The account photo should change after the selected file
    * After clicking the Edit button, the phone menu should be updated.
    * Save button should be functional
    Then After clicking the Save button, "Your phone number has been updated." should be displayed.
    * Toogle the menu button must be functional
    * Clicking the menu button on the Tooglle should change the menu dimensions.