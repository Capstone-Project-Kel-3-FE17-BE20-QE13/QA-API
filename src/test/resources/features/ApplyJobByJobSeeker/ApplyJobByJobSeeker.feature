Feature: Apply job by job seeker

  @JobSeeker
  Scenario Outline: [PAP001] Apply job with param id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has been logged in and vacancy id <vacancy_id>
    When Send request post apply job
    Then Status code should be 200
    And Response body message was "success create application"
    Examples:
      | vacancy_id |
      | 26         |
      | 27         |
      | 28         |

  @JobSeeker
  Scenario Outline: [PAP002] Apply job more than 3 job applications
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has been logged in and vacancy id <vacancy_id>
    When Send request post apply job
    Then Status code should be 403
    And Response body message was "error insert data, Unverified user can't make more than 3 applications"
    Examples:
      | vacancy_id |
      | 25         |

  @JobSeeker
  Scenario Outline: [PAP003] Apply job with param id more than 3 applications for verified account
    Given User login with json file "LGJ001_verif.json"
    When Send request post login job seeker with valid data
    Given Job seeker has been logged in and vacancy id <vacancy_id>
    When Send request post apply job
    Then Status code should be 200
    And Response body message was "success create application"
    Examples:
      | vacancy_id |
      | 26         |
      | 27         |
      | 28         |
      | 25         |

  @JobSeeker
  Scenario: [GAJ001] Get all applications job seeker
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker has logged in
    When Send request get all applications
    Then Status code should be 200
    And Response body message was "successfully get all applications history"