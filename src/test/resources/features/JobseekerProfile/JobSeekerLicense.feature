Feature: Job Seeker License

  @JobSeeker
  Scenario Outline: [PUL001] Post user license
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker with "<license_name>", "<pub_date>", "<exp_date>", and "<license>"
    When Send request post user license
    Then Status code should be 200
    And Response body message was "successfully create license"
    And Validate json schema "MessageSchema.json"
    Examples:
      | license_name | pub_date                 | exp_date                 | license     |
      | certificate  | 2024-02-12T17:01:00.300Z | 2027-02-12T17:01:00.300Z | LICENSE.pdf |

  @JobSeeker
  Scenario: [GUL001] Get all user licenses
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker licenses
    When Send request get all user licenses
    Then Status code should be 200
    And Response body message was "successfully get all licenses"

  @JobSeeker
  Scenario: [GUL002] Get user license with valid id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker license with valid id
    When Send request get license with id
    Then Status code should be 200
    And Response body message was "successfully get detail license"

  @JobSeeker
  Scenario Outline: [UUL001] Update license with valid id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker with valid license id and form data "<license_name>", "<pub_date>", "<exp_date>", and "<license>"
    When Send request put license with id
    Then Status code should be 200
    And Response body message was "successfully update license"
    And Validate json schema "MessageSchema.json"
    Examples:
      | license_name  | pub_date                 | exp_date                 | license     |
      | certificate 2 | 2024-02-12T17:01:00.300Z | 2027-02-12T17:01:00.300Z | LICENSE.pdf |

  @JobSeeker
  Scenario: [DUL001] Delete license with valid id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Job seeker license with valid id
    When Send request delete license with id
    Then Status code should be 200
    And Response body message was "successfully delete license"
    And Validate json schema "MessageSchema.json"

#  @JobSeeker
#  Scenario Outline: [PUL001] Post user license
#    Given User login with json file "LGJ001.json"
#    When Send request post login job seeker with valid data
#    Given Job seeker with "<license_name>", "<pub_date>", "<exp_date>", and "<license>"
#    When Send request post user license
#    Then Status code should be 200
#    And Response body message was "successfully create license"
#    Examples:
#      | license_name | pub_date                 | exp_date                 | license     |
#      | certificate  | 2024-02-12T17:01:00.300Z | 2027-02-12T17:01:00.300Z | LICENSE.pdf |
