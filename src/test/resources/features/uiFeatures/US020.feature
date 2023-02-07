
# User should be able to perform various operations on homepage
Feature: US020 Company (Botton)-Footer
 About Us should be clickable and relevant page should be visible

 @UI
 Scenario: TC001_About Us should be clickable and relevant page should be visible

 Given the user goes to "https://test.urbanicfarm.com/".
 And the user scrolls down the home page.
 And the user clicks the "About Us".
 Then the user verifies the About us is enabled.
 Then the user verifies the page is "https://test.urbanicfarm.com/about".
 And the user navigate to current.
