#MANUAL Olarak yapildi
#Map screen must be functional
#Buttons for zoom should be functional +, - (manuel)
#View larger map button should be functional (manuel)
#Clicking View larger map should open a new screen (manuel)
#Satellite button must be functional
#When the Satellite button is clicked, the relevant change should be seen on the screen
#When the Map is clicked, it should be seen that there is Terrain under it and it can be clicked,
# Satellite has a Label under it and it can be clicked


Feature: As a user, after entering valid information, I should be able to perform various actions in the map section

  Scenario: US053-TC01
    Given user goes to "https://test.urbanicfarm.com/"
    And User clicks login button on the home page
    And User enters a valid email "us050Email"
    And user enters valid password "us050Password"
    Then the user clicks login button on the login page
    And user verifies that zoom option is functional
    And user clicks on view larger map
    And user verifies that view larger map is functional
    And user clicks on satellite button
    And user verifies that relevant page change seen on the screen
    When user clicks on terrain option under the satellite
    Then user verifies that relevant option is visible

