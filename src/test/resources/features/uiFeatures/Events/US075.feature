Feature: As a user, should able to attend the someone's event(s)

  @UI
  @US075
    Scenario:

    Given User login as "buyerToken" to "account/events"
      And User clicks on register
      And User clicks on Terms and conditions box
      And User clicks on Approve button
      Then User verifies valid registered message "You have now registered to this event" if the event free
      Then User verifies valid registered message "Check out captured. You can close this tab now." if the event required fee
      Then User should see the event on the Registered Events page
