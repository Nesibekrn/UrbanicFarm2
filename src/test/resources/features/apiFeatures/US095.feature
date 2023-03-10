Feature: User create new Hub
  @0095
  Scenario Outline:
    Given user login in with api
    Then  User crate new Hub info "<Hub>"
    Examples:
      | Hub |
    |ARDENING TOOLS HUB|