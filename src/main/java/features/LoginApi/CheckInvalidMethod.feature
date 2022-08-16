@LoginApi
Feature: Check invalid method

  @TC01
  Scenario: Check invalid method
    Given I have url "https://reqres.in/api/login" and invalid method "GET"
    When I send request with invaild metthod
    Then The response return status code 200 success
