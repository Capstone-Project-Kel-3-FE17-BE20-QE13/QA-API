Feature: Job Seeker License

  Scenario Outline: [PUL001] Post user license
    Given Job seeker with "<license_name>", "<pub_date>", "<exp_date>", and "<license>"
    When Send request post user license
    Then Status code should be 200
    And Response body message was "successfully create license"
    Examples:
      | license_name | pub_date                 | exp_date                 | license     |
      | certificate  | 2024-02-12T17:01:00.300Z | 2027-02-12T17:01:00.300Z | LICENSE.pdf |

  Scenario: [GUL001] Get all user licenses
    Given Job seeker licenses
    When Send request get all user licenses
    Then Status code should be 200
    And Response body message was "successfully get all licenses"

  Scenario: [GUL002] Get user license with valid id
    Given Job seeker license with valid id
    When Send request get license with id
    Then Status code should be 200
    And Response body message was "successfully get detail license"

  Scenario Outline: [UUL001] Update license with valid id
    Given Job seeker with valid license id and form data "<license_name>", "<pub_date>", "<exp_date>", and "<license>"
    When Send request put license with id
    Then Status code should be 200
    And Response body message was "successfully update license"
    Examples:
      | license_name  | pub_date                 | exp_date                 | license     |
      | certificate 2 | 2024-02-12T17:01:00.300Z | 2027-02-12T17:01:00.300Z | LICENSE.pdf |

  Scenario: [DUL001] Delete license with valid id
      Given Job seeker license with valid id
      When Send request delete license with id
      Then Status code should be 200
      And Response body message was "successfully delete license"
