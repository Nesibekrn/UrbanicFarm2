@aynur
@US101
Feature: As a user, I should be able to request a new product.

  Scenario:
    Given user logs in with api for new product request
    Given user can request for a new product

      | description     | YAZ URUNLERI             |
      | relatedHub      | VEGETABLES_AND_FRUITS_HUB|
      | title           | ADORATION TOMATO         |

    Then user verifies the request product status code is 200
    Then User verifies the request product response








