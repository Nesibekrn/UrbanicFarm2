Feature: US02_Titles
  Background:
    Given User goes to "https://test.urbanicfarm.com/"

  @UI
  @US02
  Scenario: US02_TC01_Titles
    Given User verifies Urbanic Farm Logo is visible
    And User verifies "Support the local food movement" link is displayed
    And User verifies "<headers>" is visible
      | Blog                            |
      | Explore                         |
      | About Us                        |
      | Contact Us                      |
      | Login                           |
      | Register                        |