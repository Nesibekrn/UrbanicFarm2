# HomePage US_016 User should be able to perform various operations on homepage



#Sevinc
Feature:US_016_TC_001, Explore (Bottom)-Footer, Blog should be clickable and relevant page should be visible
  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    And user goes to bottom page
  @UI
  @US_016
  Scenario: Blog should be clickable
    And user clicks on Blog option under the Explore Icon
    Then user verifies that current url
  #"https://urbanicfarm.com/blog/"
