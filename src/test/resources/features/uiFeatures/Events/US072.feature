@UI
@US072_TC001
Feature: US072 User goes to Events page

  Background:
    And User goes to My Event page

  Scenario Outline: User goes to my events page
    Given User goes to click Create New Event
    And  when user enter this info "<Title>","<Address>","<Date>","<Time>","<Fee>","<Duration>","<Attendee>","<Schedule>","<Description>","<Ters and Conditions>"
    Then User clicks Submit button
    Then User  check alert message"<Alert Message>","<Number>"
    Examples:
      | Title | Address    | Date     | Time   | Fee | Duration | Attendee | Schedule | Description | Ters and Conditions | Alert Message                                                                                                                                                                                  | Number |
      |       |            |          |        | 0   |          |          |          |             |                     | Please enter a valid title.,Please select an address.,Please fill this field,Please enter a valid duration.,Please enter a valid attendee limit.,Please enter valid terms and conditions.      | 7      |
      | Home  | 23456 sout | 03021222 | 215252 | 0   |          | 25       |          |             | vxczv               | Please enter a valid title.,Please select an address.,Please enter a further date,Please enter a valid duration.,Please enter a valid attendee limit.,Please enter valid terms and conditions. | 7      |
      |       |            |          |        | 0   |          | 25       |          |             | VSDFV               | Please enter a valid title.,Please select an address.,Please fill this field,Please enter a valid duration.,Please enter a valid attendee limit.,Please enter valid terms and conditions.      | 7      |
      | Home  | xcvx       |          | 215252 | 0   |          | 25       |          |             |                     | Please enter a valid title.,Please select an address.,Please fill this field,Please enter a valid duration.,Please enter a valid attendee limit.,Please enter valid terms and conditions.      | 7      |






























  #user should able to create an event by clicking "Create Event" button on Event page
#if user not provide valid data to the reqired field and clicks submit button should not able to create an event by seeing warnig message.
#title box cannot be blank if so user will see warning message "Please enter a valid title."
#address box cannot be blank if so user will see warning message "Please select an address."
#date box cannot be blank if so user will see warning message "Please select a date."
#time box cannot be blank if so user will see warning message "Please enter a time."
#fee box cannot be blank if so user will see warning message "Please provide a fee."
#duration box cannot be blank if so user will see warning message "Please enter a valid duration."
#attendee limit box cannot be blank if so user will see warning message "Please enter a valid attendee limit."
#terms and condition box cannot be blank if so user will see warning message "Please enter a valid terms and conditions."
#user should able to cancel create event by clickng GO Back button