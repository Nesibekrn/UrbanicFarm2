Feature:US_098 As a user, I should be able to add a product to the hub.

  @US098
  Scenario:US_098 As a user, I should be able to add a product to the hub.

    Given User login API with token to add product
    When  User add a product

      | hubUniqueName     | VEGETABLES_AND_FRUITS_HUB         |
      | price             | 0.50                              |
      | productUniqueName | VEGETABLES_AND_FRUITS_HUB_ASPARAGUS |
      | stock             | 1500                              |
      | isOrganic         | true                              |
      | isTrade           | true                              |
      | unit              | UNIT_LIBRE                        |
    Then  User verifies success is true
    And  User deletes added product
      | hubUniqueName     | VEGETABLES_AND_FRUITS_HUB         |
      | productUniqueName | VEGETABLES_AND_FRUITS_HUB_ASPARAGUS |
