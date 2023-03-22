Feature:

  @US108
  Scenario:
    Given User goes to API as Seller
    And User gets all Events Details
    Then User verifies if status code is 200
    Then User verifies success is True