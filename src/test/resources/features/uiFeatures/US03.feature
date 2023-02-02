Feature:
  Background:
    Given User goes to "https://test.urbanicfarm.com/"
  @UI
  @US03
  Scenario: US03_TC01
    Given User verifies Blog Link is clickable and clicks
    Then User verifies relevant Blog Page with url