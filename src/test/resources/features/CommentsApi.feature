Feature: Comments Api tests

  @comments
  Scenario Outline: Comments section email format should be valid under all posts created by a specific valid user
    Given a user with username "<userName>"
    And the username "<userName>" validity is determined
    When user id is retrieved for username "<userName>"
    And post ids are retrieved for username "<userName>"
    And comments api is invoked for all the posts created by username "<userName>"
    Then response status code should be "<statusCode>"
    And comments response email format validation should "<commentEmailFormatValidationStatus>" for username "<userName>"

    Examples: 
      | userName | statusCode | commentEmailFormatValidationStatus |
      | Delphine |        200 | PASS                               |
      | Bret     |        200 | PASS                               |      
      | PAVAN    |        200 | FAIL                               |
