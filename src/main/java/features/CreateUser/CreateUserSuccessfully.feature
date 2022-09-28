@CreateUser
Feature: Create user succesfully
  I want to use this template for my feature file

  @MainCase
  Scenario Outline: Create user succesfully
    Given I have Url and Method and RequestBodyName
      | url                            | method | requestBodyName            |
      | https://reqres.in/api/users | POST   | CreateUserRequestBody.json |
    When I send the request with valid data
    Then Request reponse return "<statusCode>" and responseBody "<job>" and "<name>"
    Examples:
      | statusCode | job    | name     |
      |        200 | leader | morpheus |
