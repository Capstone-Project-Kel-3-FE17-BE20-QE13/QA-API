Feature: Vacancy by Job Seekers

  @JobSeeker
  Scenario: [GVC001] Get all vacancies by job seeker
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has logged in
    When Send request get all vacancies
    Then Status code should be 200
    And Response body message was "success read data."

  @JobSeeker
  Scenario: [GVC002] Get vacancy with valid vacancy id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Vacancy with valid id
    When Send request get detail vacancy
    Then Status code should be 200
    And Response body message was "success read data."

  @JobSeeker
  Scenario: [PVC001] Post new vacancy by job seeker
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has logged in and file json "PVC001.json"
    When Send request post new vacancy by job seeker
    Then Status code should be 403

  @JobSeeker
  Scenario: [PVC002] Add vacancy with id to favorite
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has logged in and valid vacancy id
    When Send request add vacancy to favorite
    Then Status code should be 200
    And Response body message was "success create favourite"

  @JobSeeker
  Scenario: [DVC001] Delete Vacancy from Favorite
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Vacancy with valid id
    When Send request delete vacancy from favorite
    Then Status code should be 200
    And Response body message was "success delete data"

  @JobSeeker
  Scenario: [GVC003] Get all favorite vacancies
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has logged in
    When Send request get all favorite vacancies
    Then Status code should be 200
    And Response body message was "success read all favourites"


