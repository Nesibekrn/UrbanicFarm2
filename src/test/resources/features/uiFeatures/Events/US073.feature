#As a user, should be able to add an address successfully by providing with valid data
#Create Event
#user should be able to add an address by clicking add button on
#create event page
#user should provide Title for the event, it is requred field
#user should provide address for the event; it is required filed
#user should type or select the city for the event, it is required filed
#user should type or select the state for the event, it is required.
#filed
#user should provide Zip code for the event, it is required filed
#user should be able to add an address by clicking "Submit " button.
#seeing successful message "Address successfully added."

@UI
@073
Feature: US073_User should be able to add an address successfully by providing with valid data

  Background:
    And User goes to My Event page

  Scenario Outline: US073_TC_001_User should be able to add an address successfully by providing with valid data
    Given User goes to click Create New Event
    And User click on Add button
    And  when user enter this info "<Address Title>" ,"<Address>","<State>","<City>","<Postal/Zip>"
    Then User clicks My events Submit button
#    this message is not working
  Then user verifies the  "Address successfully added." message

    Examples:
      | Address Title | Address         | State   | City      | Postal/Zip |
      | Home          | 222 Snowman Ave | Alabama | Alabaster | 13579      |

#    this step is extra
  Scenario:US073_TC_002_User should be able to add an address successfully by providing with valid data
    And User click on Address button
    And user goes to bottom of the page
    Then user verifies that Added address is display
