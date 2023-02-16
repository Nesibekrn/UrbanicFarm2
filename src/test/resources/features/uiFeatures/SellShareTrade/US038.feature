Feature: About us-Contact us-Scheduled delivery-Events-User-Logout-Notifications-Cart  should be visible
  @UI
  @US038
    Scenario: US038_TC01
      Given user goes to "https://test.urbanicfarm.com/"
      And User click the login link
      When User enter valid email address & password & clicks the login button
      Then User verifies "<headers>" is visible on Sell Share Trade-A
        | About us                        |
        | Contact us                      |
        | Scheduled delivery              |
        | Cristian                        |
        | Logout                          |
      Then User verifies "<headers>" is visible on Sell Share Trade-Div
        | Events                          |
        |Notifications                    |
        | Cart                            |

