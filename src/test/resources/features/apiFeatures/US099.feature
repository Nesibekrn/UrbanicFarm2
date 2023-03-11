Feature:


  @US099
  Scenario:
    Given User logs in with API for updating the product
    When user updates the product


      | hubUniqueName     | DAIRY_HUB |
      | productUniqueName | EGG       |
      | price             | 15        |
      | stock             | 200       |

    Then user verifies that update function works

      | success       | true |
      | product.price | 15   |
      | product.stock | 200  |