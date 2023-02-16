Feature: US028_TC001_LinkedIn icon should be clickable and relevant page should be visible

  Background: Going to URL
    Given User goes to "https://test.urbanicfarm.com"

   @UI
   @US028
  Scenario: To check if LinkedIn link is clickable and passing to LinkedIn page when it clicked
     And User scrolls down to the Bootm End on the home page
     Then User checks the LinkedIn button is clickable
     Then User clicks the LinkedIn button
     Then User verifies if LinkedIn page is visible