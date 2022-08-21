
@CreateUser
Feature: Create user succesfully
  I want to use this template for my feature file

  @MainCase
  Scenario: Create user succesfully
    Given I have Url and Method and RequestBodyName
     | url  | method | requestBodyName  |
     | https://reqres.in/api/register |     POST | CreateUserRequetsBody.json | 

    When I send the request

    Then Request reponse return "<statusCode>" and responseBody "<job>" and "<name>"
    | statusCode  | job | name  |
      | 200 |     leader| morpheus |
    



