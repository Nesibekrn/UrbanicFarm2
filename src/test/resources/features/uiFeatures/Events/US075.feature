Feature: As a user, should able to attend the someone's event(s)

  @UI
  @US075
    Scenario:

    Given User login as "buyerToken" to "account/events"
      And user clicks on register
      And user clicks on Terms and conditions box
      And user clicks on Approve button
      Then user verifies valid registered message "You have now registered to this event" if the event free
      Then user verifies valid registered message "Check out captured. You can close this tab now." if the event required fee
      Then user should see the event on the Registered Events page
