Feature: US035 As a user I should be able to login with my account

  Background:
    Given User goes to "https://test.urbanicfarm.com"

  @UI
  @US035
  Scenario:
    When User clicks login link
    Then User clicks on email address box
    Then User clicks on password box
    Then User enters a valid email,password and clicks the login button
    Then User closes the "Welcome to Urbanic Farm!" alert

    #Then Welcome to Urbanic Farm! #kullanıcı uyarınn görüntlendiğini doğrular
    #açılan uyarıyı kapatır
    #Then User logs in after entering valid information


