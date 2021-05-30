Feature: Posts Api tests


  Scenario Outline: Posts details should be retrieved only for valid usernames

    Given a user with username "<userName>"
    And the username "<userName>" is valid
    When user id is retrieved for username "<userName>"
    And posts api is invoked for username "<userName>"
    Then response status code should be "<statusCode>"
    And postId retrieval should be successful for username "<userName>"

    Examples:
      | userName | statusCode |
      | Bret     | 200        |
      | Samantha | 200        |




