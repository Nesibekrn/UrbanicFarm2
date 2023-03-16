@UI
@074
Feature: US074_As a user, should not able to add an address successfully by providing with invalid data
  Background:
    And User goes to My Event page
  Scenario Outline: US074_TC_001_User should be able to add an address successfully by providing with valid data
    Given User goes to click Create New Event
    And User click on Add button
    And  when user enter this info "<Address Title>" ,"<Address>","<State>","<City>","<Postal/Zip>"
    When User clicks My events Submit button
    Then User see the alert messages "<Alert message>","<Number>"
    Examples:
      | Address Title | Address         | State | City    | Postal/Zip | Alert message                                                                                                                                     | Number |
      |               |                 |       |         |            | Please enter a valid title.,Please enter a valid address.,Please enter a valid state.,Please select a city.,Please enter a valid postal/zip code. | 5      |
      | H             |                 | Izmir |         | 13579      | Please enter a valid title.,Please enter a valid address.,Please select a city.                                                                   | 5     |
     | Ho            | 222 Snowman Ave | 45621 | Turkiye |            | Please enter a valid postal/zip code.                                                                                                             | 5      |
   | Home          | 222 Snowman Ave |       |         | 13579      | Please enter a valid state.,Please select a city.                                                                                                 | 5      |

#  Scenario: US074_TC_002 User enter the invalid address title
#    When User enter invalid "AddressTitle