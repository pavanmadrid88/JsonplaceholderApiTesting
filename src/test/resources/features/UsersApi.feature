Feature: UsersApi

  @users
  Scenario Outline: User details should be retrieved only for valid usernames.
    Given a user with username "<userName>"
    And the username "<userName>" validity is determined
    When users api is invoked for username "<userName>"
    Then response status code should be "<statusCode>"
    And userId retrieval should be "<userIdRetrivalStatus>" for username "<userName>"

    Examples: 
      | userName | statusCode | userIdRetrivalStatus |
      | Delphine |        200 | PASS                 |
      | Bret     |        200 | PASS                 |     
      | Pavan    |        200 | FAIL                 |
