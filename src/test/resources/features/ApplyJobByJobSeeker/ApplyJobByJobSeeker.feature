Feature: Apply job by job seeker

  @JobSeeker
  Scenario Outline: [PAP001] Apply job with param id
    Given Job seeker has been logged in and vacancy id <vacancy_id>
    When Send request post apply job
    Then Status code should be 200
    And Response body message was "success create application"
    Examples:
      | vacancy_id |
      | 23         |

  @JobSeeker
  Scenario: [GAJ001] Get all applications job seeker
    Given Job seeker has logged in
    When Send request get all applications
    Then Status code should be 200
    And Response body message was "successfully get all applications history"