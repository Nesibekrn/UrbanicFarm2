Feature: US042 Events should be clickable and relevant page should be visible on the Sale-Pay-Trade page

  Background:

    Given the user goes to "https://test.urbanicfarm.com/account/home".

  @UI
  @042
  Scenario: TC001 Events should be clickable and relevant page should be visible on the Sale-Pay-Trade page


    When the user clicks login module button
    Then the user verifies the page is "https://test.urbanicfarm.com/auth/login".
    And the user fill out valid email "urbanicfarm2@yopmail.com" in username text box
    And the user fill out valid email "Urbanicfarm2/" in password text box
    And the user clicks login button on the login page
    Then the user verifes page is "https://test.urbanicfarm.com/home"
    Then the user verifies account name is displayed
    And the user clicks Sale-Pay-Trade module
    Then the user verifies Sale-Pay-Trade modele is enabled
    Then the user verifes page is "https://test.urbanicfarm.com/account/hub"
    And the user clicks events button
    Then the user verifes page is "https://test.urbanicfarm.com/account/events"
    And the user navigate to current.
