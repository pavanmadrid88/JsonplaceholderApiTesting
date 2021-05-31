Feature: Posts Api tests

  @posts
  Scenario Outline: Posts details should be retrieved only for valid usernames
    Given a user with username "<userName>"
    And the username "<userName>" validity is determined
    When user id is retrieved for username "<userName>"
    And posts api is invoked for username "<userName>"
    Then response status code should be "<statusCode>"
    And postId retrieval should be "<postIdRetrivalStatus>" for username "<userName>"

    Examples: 
      | userName | statusCode | postIdRetrivalStatus |
      | Delphine |        200 | PASS                 |
      | Bret     |        200 | PASS                 |   
      | Pavan    |        200 | FAIL                 |
