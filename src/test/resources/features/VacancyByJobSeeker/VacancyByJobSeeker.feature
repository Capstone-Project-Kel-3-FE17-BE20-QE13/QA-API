Feature: Vacancy by Job Seekers

  Scenario: [GVC001] Get all vacancies by job seeker
    Given Job seeker has logged in
    When Send request get all vacancies
    Then Status code should be 200
    And Response body message was "success read data"

  Scenario: [GVC002] Get vacancy with valid vacancy id
    Given Vacancy with valid id
    When Send request get detail vacancy
    Then Status code should be 200
    And Response body message was "success read data"


