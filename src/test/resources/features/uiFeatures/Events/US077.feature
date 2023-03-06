@UI
@US077
Feature:As a User, should able to delete the event

  Background:
    Given  User goes to "https://test.urbanicfarm.com/"
    And User click the Login link
    Then User enter valid email address & password & clicks the login buttonu
    And the user clicks account name
    And User clicks My Events link

  @US077_TC_01
    @UI
  Scenario Outline: US077_TC_01
    And User clicks Create New Event button
    And User verifies  the Create Event Page
    And User clicks on the Add button
    And User enters Adress info "<Title Address>","<Address1>","<State>","<City>","<Postal>"
    And click Submit button
    And User fills the Create Event Page "<Title>","<Address>","<Date>","<Time>","<Duration>","<Attendee>","<Terms and Conditions>"
    And User click Submit button
    Examples:
      | Title   | Address | Date       | Time  | Duration | Attendee | Terms and Conditions | Title Address | Address1    | State | City | Postal |
      | Meeting | Home    | 10.11.2023 | 19.15 | 90       | 90       | Business Man         | Apartman      | kemaloz mah | Ege   | Usak | 64200  |

  @US077_TC_02
  @UI
  Scenario:US077_TC_02 User should able to delete event on Scheduled Events page by clicking Delete button
    And User clicks the Delete button on the My Scheduled Events page that open

  @UI
  @US077_TC_03
  Scenario: US077_TC-03 There should be cancel button for deletion of event
    And User clicks the Delete button on the My Scheduled Events page that open
    And User sees "Are you sure you want to delete this event?" text
    And User clicks the No button

  @US077_TC_04
  @UI
  Scenario: US077_TC_04 If User accept to delete the event will see message "Event deleted" and
  event should not be on the list of Scheduled Events
    And User clicks the Delete button on the My Scheduled Events page that open
    And User sees "Are you sure you want to delete this event?" text
    And User click the Yes button
    And User sees "Event deleted" message
    And User sees "Event deleted" text and event is not in Scheduled Events List

