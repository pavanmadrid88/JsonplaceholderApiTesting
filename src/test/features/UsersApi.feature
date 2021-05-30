Feature: UsersApi

  Scenario Outline: User details should be retrieved only for valid usernames.

    Given a user with username "<userName>"
    And the username "<userName>" is valid
    When users api is invoked for username "<userName>"
    Then response status code should be "<statusCode>"
    And userId retrieval should be successful for username "<userName>"

    Examples:
      | userName | statusCode |
      | Bret     | 200        |
      | Delphine | 200        |



