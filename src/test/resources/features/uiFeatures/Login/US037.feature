@UI
@US37
Feature: US037 As a user Forgot your password? and I should be able to check the new password creation process

  Background:
    Given User goes to "https://test.urbanicfarm.com"
    When User verifies Login Link is clickable and clicks
    And User clicks Forgot Password Link
    Then User verifies Please verify your email Text is visible

  @UI
  @US37
  Scenario: Positive Scenario
    Then User enters a valid email
    Then User clicks Verify Email Button
    Then User verifies "We have sent the password reset link to your email. Check your mail box." message is visible
    Then User clicks Reset Your Password Link on the yopmail
    Then User verifies Change Password title
    Then User enters a valid new password into the New Password box and Confirm Password box
    Then User clicks submit button
    Then User verifies "You password has been successfully changed.." alert is displayed
    Then User verifies to navigate to the Login Page

      @UI
  @US37_TC02
  Scenario: Negative Scenario for not registered email
    Then User enters an invalid email
    Then User clicks Verify Email Button
    And User verifies "We cannot find an account with that e-mail address." alert is displayed


  @UI
  @US37_TC03
  Scenario: Negative Scenario for old email
    Then User enters a valid email
    Then User clicks Verify Email Button
    Then User verifies "We have sent the password reset link to your email. Check your mail box." message is visible
    Then User clicks Reset Your Password Link on the yopmail
    Then User verifies Change Password title
    Then User enters old password into the New Password box and Confirm Password box
    Then User clicks submit button
    Then User verifies "You used your old password. Please enter a new password.." alert is displayed