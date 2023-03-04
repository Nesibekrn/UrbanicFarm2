@UI
@US078
Feature: US078_TC001_

  Background: User goes to URL
    Given User goes to My Event page

  Scenario Outline:  To check cancel/complete/share event(s) in Module of Events
    And User goes to click Create New Event
    And  when user enter this info "<Title>","<Address>","<Date>","<Time>","<Fee>","<Duration>","<Attendee>","<Schedule>","<Description>","<Ters and Conditions>"
    Then User clicks Submit button to success new page
    Then User clicks Close toast message about creation of Event
    And User clicks Cancel button and verifies seeing "Event canceled" message
    Then User verifies seeing of Canceled sign
    And User clicks Mark as Completed button and verifies seeing "Event marked as completed" message
    Then User verifies seeing of Completed sign
    And User clicks Copy Link button and verifies seeing "Event Link Copied to Clipboard" message
    Examples:
      | Title  | Address | Date     | Time  | Fee | Duration | Attendee | Schedule | Description | Ters and Conditions |
      | Bright | Home    | 03102023 | 0930P | 15  | 30       | 20       | fdsfdds  | dfsdf       | For Kids            |


#  user should able to cancel event by clicking Cancel button by seeeing "Event canceled" message
#  there should be "Cancelled" sign when event cancelled
#  user should able to completed event by clicking mark as completed button by seeing "Event marked as completed" message
#  there should be "Completed" sign when event cancelled
#  user should able to copy event link by clicking Copy link button by seeeing "Event Link Copied to Clipboard" message