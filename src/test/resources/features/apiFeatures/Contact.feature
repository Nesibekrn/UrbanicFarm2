Feature: As a user, I should be able to contact to Urbanic Farm

  @contact
#  @aynur
  Scenario:Send a post request and verify the statusCode and server
#    //Given user logs in with api
    Given user sends post request using the api "https://test.urbanicfarm.com/api/public/contact"
    And  user verifies the status code  200
    And user verifies the server in header

