@UI
@US071

Feature: US071_TC001 As a User, should able to create Event(s)

  Background: User goes to URL
    Given User goes to My Event page


  Scenario Outline: User creats New Event in My Events Page and verifies
    And User goes to click Create New Event
    And when user enter this info "<Title>","<Address>","<Date>","<Time>","<Fee>","<Duration>","<Attendee>","<Schedule>","<Description>","<Ters and Conditions>"
    Then User clicks Submit button2
    And User verifies event created alert massages
    And User verifies new sign massages
    Examples:
      | Title      | Address | Date       | Time     | Fee  | Duration | Attendee | Ters and Conditions |Schedule |Description|
      | urunler2    | Home    | 03052023   | 0930A    |      | 30       | 30       | sureli              |hicbirsey|djaghj     |




