Feature: US_094 As a user, I should be able to get existing hubs' information

  //aziz
  @US094
  Scenario:
    Given User logs in API as Seller
    When User gets hub list
    Then User verifies the status code is 200
