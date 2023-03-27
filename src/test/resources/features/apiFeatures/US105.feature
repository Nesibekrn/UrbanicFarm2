#Notifications
#User should be able to get all conversations.
#https://test.urbanicfarm.com/api/chat/getConversations
#Details on the swagger document.
@US105
  Feature: US105 As a user, I should be able to get all conversations.
    Scenario: US105 As a user, I should be able to get all conversations.
      Given User logs in API as for notification
      When User get all conversations
      Then User verify response is expected