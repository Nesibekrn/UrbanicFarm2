# As a user, after entering valid information, I should be able to perform various actions in the Welcome Page


  #Ugur

  Feature: US_064 As a user, after entering valid information, I should be able to perform various actions in the Welcome Page
   Background:Going to URL
     Given User goes to "https://test.urbanicfarm.com/"
     And User click the Login link
     Then User enter valid email address & password & clicks the login buttonu

    @US064
    @UI
    Scenario: Any seller rating icons must be clickable
    Then User seller rating icon clicked

    Scenario: When clicking Any seller rating, rating should be selected from the dropdown
      Then User seller rating icon clicked
      Then User selected seller rating from the dropdown menu

      Scenario: The selected rating should appear on the screen
        Then User seller rating icon clicked
        Then User selected seller rating from the dropdown menu
        Then User displays the selected seller rating on the screen


     Scenario: Any product rating icon must be clickable
          Then User product seller rating icon clicked

          Scenario: When any product rating is clickable, rating should be selected from the dropdown menu
            Then User product seller rating icon clicked
            Then User selected product rating from the dropdown menu

            Scenario: The selected rating should appear on the screen
              Then User product seller rating icon clicked
              Then User selected product rating from the dropdown menu
              Then User displays the selected  product rating on the screen
