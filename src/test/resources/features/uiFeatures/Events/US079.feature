@UI
@US079
Feature: US079_TC001_As a user, I should be able to click on the notifications button and perform various actions

  Background:
    Given  User login as "us050Token" to "account/events-i-organize"

  Scenario:  Should be able to click on the notifications button and perform various actions
    When User updates an event
    And User login as "us050Token" to "account/events"
    And User clicks the Notification button
    Then User verifies that if there is any notification listed there should be options as Mark all as read and Filter by unread
    Then User verifies that there should be option to make notification read or unread
    Then User verifies that there should be an option View All if there is no any notifications
