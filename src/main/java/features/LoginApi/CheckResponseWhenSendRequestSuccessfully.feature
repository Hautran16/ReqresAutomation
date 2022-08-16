
@LoginApi
Feature: Check response when send request successfully
  @MainCase
  Scenario: Check response when send request successfully
    Given I have Url "https://reqres.in/api/login" and method "GET" and body request "request body"

    When Send request 
 
    Then The reponse returns status code 200

    