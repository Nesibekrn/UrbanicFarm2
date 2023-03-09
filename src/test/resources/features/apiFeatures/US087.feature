@US087
Feature: As a user, I should be able to add an address.

  Scenario Outline:
    Given User login with APİ user
    When User adds addresses "<Address>","<City>","<isDefault>","<isSellerAddress>","<postal>","<State>","<title>","<emptyBasket>"
    And user gets the status code 200
    Then User verifies the response
    Examples:
      | Address | City   | isDefault | isSellerAddress | postal | State | title  | emptyBasket |
      | England | London | true      | true            | 1458   | stat  | Home   | false       |
      | Holland | CA     | false     | true            | 8453   | stat  | Online | true        |




