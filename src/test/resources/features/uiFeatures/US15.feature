Feature:

  @UI
  @US15

    Scenario: The Go Wefunder button in the Invest in Urbanic Farm header should be clickable
    Given User goes to home page
    Then  User assert the go wefunder  button is clickable
    When  User clicks on go wefunder button
    Then  User verified the url is "https://wefunder.com/urbanicfarm"