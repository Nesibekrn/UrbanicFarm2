Feature: US042 Events should be clickable and relevant page should be visible on the Sale-Pay-Trade page

  @UI
  Scenario: TC001 Events should be clickable and relevant page should be visible on the Sale-Pay-Trade page


    Given the user goes to "https://test.urbanicfarm.com/account/home".
    When the user clicks login module button
    Then the user verifies the page is "https://test.urbanicfarm.com/auth/login".
    And the user fill out valid email "hgfcushbyt@gmail.com" in username text box
    And the user fill out valid email "123456789H@_m" in password text box
    And the user clicks login button on the login page
    Then the user verifes page is "https://test.urbanicfarm.com/home"
    Then the user verifies account name is displayed
    And the user clicks Sale-Pay-Trade module
    Then the user verifies Sale-Pay-Trade modele is enabled
    Then the user verifes page is "https://test.urbanicfarm.com/account/home"
    And the user clicks events button
    Then the user verifes page is "https://test.urbanicfarm.com/account/events"
    And the user navigate to current.
