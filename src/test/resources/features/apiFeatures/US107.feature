Feature: US_107 As a user, I should be able to recieve all notifications.

  Scenario:
    Given User logs in API as Seller for get Notifications
    And User gets notifications
    Then User verifies response is expected