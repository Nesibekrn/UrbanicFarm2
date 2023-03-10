Feature: US_089 As a user, I should be able to delete an existing address.

  @US089
  Scenario: US_089 As a user, I should be able to delete an existing address.
    Given User logs in with api for deletion address
    When User add an address
      | address         | Yemyeşil  |
      | city            | Bolu  |
      | isDefault       | false   |
      | isSellerAddress | false   |
      | postal          | 06152   |
      | state           | Akdeniz |
      | title           | Online  |
      | emptyBasket?    | true    |
    When User deletes existing address from api
    Then User verifies that success is true