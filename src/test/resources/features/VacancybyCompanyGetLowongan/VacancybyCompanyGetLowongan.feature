Feature: Create Vacancy by Company

  Scenario: [CCV001] Company create a job vacancy
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Company create a job vacancy
    When Send request get vacancy
    Then Status code should be 200




