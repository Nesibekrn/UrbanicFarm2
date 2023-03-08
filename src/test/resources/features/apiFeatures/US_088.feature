#US_088, As a user, I should be able to update an existing address.
# Address
#User should be able to update an existing address.
#https://test.urbanicfarm.com/api/account/address/update
#Details on the swagger document.

  #  Sevinc

Feature: US_088 As a user, I should be able to update an existing address.
  @US_088
    @update
  Scenario: TC_001 I should be able to update an existing address.
    Given user connects to the "/public/login" api
    And the user updates the address
    Then the user verifies that the status code is 200







