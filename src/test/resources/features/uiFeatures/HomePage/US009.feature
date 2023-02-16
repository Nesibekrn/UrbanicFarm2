#Given user goes to "https://test.urbanicfarm.com"
#And user clicks on "Get fresh produce" button
#Then user verifies that current url
@UI
@US009
Feature:User should be able to perform various operations on homepage
  Scenario: US009
    Given user goes to "https://test.urbanicfarm.com"
    And user clicks on "Get fresh produce"
    Then  verifies that current url
