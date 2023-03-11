#US_082 As a user, I should be able to login    Login
#User should be able to log in.
#https://test.urbanicfarm.com/api/public/login
#Details on the swagger document.

#  Sevinc

Feature: US_082 As a user, I should be able to login
  @US_082
  @login
  Scenario: TC_001 I should be able to login
    Given user connects to the "/public/login" api
    Then the user verifies that the status code is 200