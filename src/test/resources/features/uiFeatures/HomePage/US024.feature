Feature: US024 As a user should be able to perform various operations on homepage

  Background:
    Given User goes to "https://test.urbanicfarm.com"
    And User scrolls down

  @UI
  @US024
  Scenario:
    When User verifies that Address is visible
    Then user verifies the contents of current address


  # Adrese tiklanamiyor
  #User goes to "https://test.urbanicfarm.com"
  #User scrolls down
  #User clicks on Address under the Company
  #User verifies the contents of current address

