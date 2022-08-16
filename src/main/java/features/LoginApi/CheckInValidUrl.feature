@LoginApi
Feature: Check invalid url

  @TC02
  Scenario: Check invalid url
    Given I have invalid url "" and method ""
  
    When I send request with invaild url

    Then The response return status code 404 not found

