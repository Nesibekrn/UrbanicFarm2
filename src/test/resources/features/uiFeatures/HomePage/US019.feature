Feature: US019 User should be able to perform various operations on homepage

  Background:
    Given User goes to "https://test.urbanicfarm.com"
    And User scrolls down

  @UI
  @US019
  Scenario: US019 Clickable and visible
    When User clicks on Sell-Share-Trade under the Features bottom
    Then User verifies "Sell-Share-Trade" visible

    #Then User verifies the current url
#DATA TABLE--URL(SCENARIO OUTLINE)