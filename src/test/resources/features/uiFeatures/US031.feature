Feature: US_031, As a user, I should be able to check valid and invalid name, surname, email.
  Background:
    Given user goes to "https://test.urbanicfarm.com/"
    And user clicks on registration button on the navbar
  @UI
  @US_31
  Scenario: US_031, TC001_User should be able to check valid and invalid name, lastname, and email
    When user enter letter to first name box on the registration form
      |s|rgba(245, 110, 105, 1)|
      |12|rgba(245, 110, 105, 1)|
      |A!  |rgba(245, 110, 105, 1)|
      |Sevinc |rgba(72, 72, 72, 1)|

  Scenario: US_031 TC_002
    When user enter letter to last name box on the registration form
      |s|rgba(245, 110, 105, 1)|
      |12|rgba(245, 110, 105, 1)|
      |A!  |rgba(245, 110, 105, 1)|
      |Sevinc |rgba(72, 72, 72, 1)|

  Scenario: US_031 TC_003
    Then user enter letter to email address  box on the registration form
      |s|rgba(245, 110, 105, 1)|
      |12|rgba(245, 110, 105, 1)|
      |A!  |rgba(245, 110, 105, 1)|
      |sevinc@gmail.com |rgba(72, 72, 72, 1)|

    And user enter valid email address box on the registration form
    And user enters valid password
    And user enters confirm password
    Then user enter code in to zip code box