Feature: Job Seeker Career

  @JobSeeker
  Scenario: [PUC001] Post user career
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Post user career with json "PUC001.json"
    When Send request post user career
    Then Status code should be 200
    And Response body message was "successfully create career"
    And Validate json schema "MessageSchema.json"

  @JobSeeker
  Scenario: [GUC001] Get all user careers
    Given Get all user careers
    When Send request get all user careers
    Then Status code should be 200
    And Response body message was "successfully get all careers"

  @JobSeeker
  Scenario: [GUC002] Get User Career with Valid ID
    And Get user career with valid id
    When Send request get user career with career id
    Then Status code should be 200
    And Response body message was "successfully get detail career"

  @JobSeeker
  Scenario: [UUC001] Update user career with valid id
    Given Get all user careers
    Given Put user career with json "UUC001.json" dan valid id
    When Send request put user career
    Then Status code should be 200
    And Response body message was "successfully update career"
    And Validate json schema "MessageSchema.json"

  @JobSeeker
  Scenario: [DUC001] Delete user career with valid id
    Given Get user career with valid id
    When Send request delete user career
    Then Status code should be 200
    And Response body message was "successfully delete career"
    And Validate json schema "MessageSchema.json"

#  @JobSeeker
#  Scenario: [PUC001] Post user career
#    Given Post user career with json "PUC001.json"
#    When Send request post user career
#    Then Status code should be 200
#    And Response body message was "successfully create career"




