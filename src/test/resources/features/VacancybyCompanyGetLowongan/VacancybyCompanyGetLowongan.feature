Feature: Vacancy by Company Get Lowongan


  Scenario: [CCV001] Company create a job vacancy
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Company create a job vacancy
    When Send request get vacancy
    Then Status code should be 200
    And Response body message was "success read data."




