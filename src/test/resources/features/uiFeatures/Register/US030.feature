Feature: Name, Surname, Email, Password fields must be functional

  @UI
    @US030
  Scenario Outline: US030_TC01
    Given user goes to "https://test.urbanicfarm.com/"
    And user clicks on registration button on the navbar
    When user verifies Name, Surname, Email, Password fields are functional
    When user verifies "<Name>", "<Surname>", "<Email>", "<Password>" fields are not blank
    Then user verifies "<Allerts>" is visible


    Examples:
      | Name   | Surname | Email       | Password | Allerts                   |
      |        | yildiz  | aaaaa@g.com | Zeynep2. | Lütfen bu alanı doldurun. |
      | zeynep |         | aaaaa@g.com | Zeynep2. | Lütfen bu alanı doldurun. |
      | zeynep | yildiz  |             | Zeynep2. | Lütfen bu alanı doldurun. |
      | zeynep | yildiz  | aaaaa@g.com |          | Lütfen bu alanı doldurun. |




