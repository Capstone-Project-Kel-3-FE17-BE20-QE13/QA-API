Feature: Vacancy by Company Get Lowongan

  Scenario: [CCV001] Company create a job vacancy
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Company create a job vacancy
    When Send request post vacancy
    Then Status code should be 200
    And Response body message was "success create job"

    Scenario: [GAC001] Get all lowongan
      Given Company login with json file "LGC001.json"
      When Send request post login company
      Given Get all lowongan
      When Send request et all lowongan
      Then Status code should be 200
      And Response body message was "success read data."



