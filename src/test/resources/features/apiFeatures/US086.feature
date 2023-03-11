Feature: User get the address information

  @US086
  Scenario:
    Given User login with APİ
    Then user gets the address info
    Then user gets the status code 200
    Then User verifies the response