#Given user goes to "https://test.urbanicfarm.com/"
#And user goes to "Register"
#And user clicks on "Register" button
#Then user verifies that current url
@UI
@US008
Feature:User should be able to perform various operations on homepage
  Scenario: US008
    Given user goes to "https://test.urbanicfarm.com"
    And user clicks on "Register" button
    Then user verifies that current url for register
