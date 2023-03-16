#Notifications
#User should be able to get unread message count.
#https://test.urbanicfarm.com/api/chat/getUnreadMessagesCount
#Details on the swagger document.
  @US106
  Feature: US106 As a user, I should be able to get unread message count.
    Scenario: US106 As a user, I should be able to get unread message count.
      Given  User logs in API as for unread message
      When User get unread message count
      Then User verify  message response is expected