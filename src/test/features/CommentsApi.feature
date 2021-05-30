Feature: Comments Api tests


  Scenario Outline: Comments section email format should be valid under all posts created by a specific user

    Given a user with username "<userName>"
    And the username "<userName>" is valid
    When user id is retrieved for username "<userName>"
    And post ids are retrieved for username "<userName>"
    And comments api is invoked for all the posts created by username "<userName>"
    Then response status code should be "<statusCode>"
    And  comments response should contain valid email format for username "<userName>"

    Examples:
      | userName | statusCode |
      | Bret     | 200        |
      | Samantha | 200        |




