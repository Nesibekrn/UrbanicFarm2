Feature: Login Failure with Invalid Email and Password

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com/"
  @UI
    @US036
  Scenario Outline: Login Failure with Invalid Information
    Given  User is on the login page
    When the user enters "<email>" and "<password>" and clicks on the login button
    Then the user should see an error message indicating login failure
    And the user should not be redirected to the dashboard page

    Examples:
      | email | password |
      | invaid@email.com  | VHt*zzt*wQNu6XS   |
      | rmznkrc21@gmail.com| VHt*zzt*wQNu6XS   |
      | invlid@email.com  | VHt*zzt*wQNu6XS    |
      | invalid@email.com  | 12345   |
      |  invalid@email.com|  5345345f      |






