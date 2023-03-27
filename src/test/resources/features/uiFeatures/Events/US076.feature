#Registered Event
#number of attendee cannot be blank,negative number, 0 and can not be above attendee limits number if so box will be red and approve button will be disabled
#user must checked check box of terms and conition box otherwise aprove button will be desibled
#if user already attented the event can not register again and see message "You already attended to this event"

@UI
@US076

Feature:

  Scenario: US076

    And   User login as "sellerTokenOmer" to "account/events"
    Then  user clicks on events
    And  user clicks on Register button on events page
    Then enter data and verifies approve button is disabled and frame color is red
      | Negative value                | -1 | Value must be greater than or equal to 0. | rgba(255, 0, 0, 0 |
      | Blank                         |    | Please fill in this field.                | rgba(255, 0, 0, 0 |
      | Zero                          | 0  | Value must be bigger than 0.              | rgba(255, 0, 0, 0 |
      | Upper value of attendee limit | 1  | Value must be less than or equal to       | rgba(255, 0, 0, 0 |
      | Valid value                   | 1  |                                           | none              |
    When  User doesn't click to checkbox approve button is disabled
    Then User clicks to checkbox
    And  User clicks to approve button
    Then User login as "sellerTokenOmer" to "account/events"
    And  User clicks to register button of registered event
    And  User verifies "You've already registered this event. Please check 'Registered Events' tab." alert is disabled


