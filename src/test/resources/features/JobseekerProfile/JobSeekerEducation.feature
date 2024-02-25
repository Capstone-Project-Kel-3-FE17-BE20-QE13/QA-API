Feature: Job Seeker Education

  @JobSeeker
  Scenario: [PUE001] Post user education
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Post user education with json "PUE001.json"
    When Send request post user education
    Then Status code should be 200
    And Response body message was "successfully create education"
    And Validate json schema "MessageSchema.json"

  @JobSeeker
  Scenario: [GUE001] Get all user educations
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Get all user educations
    When Send request get all user educations
    Then Status code should be 200
    And Response body message was "successfully get all educations"

  @JobSeeker
  Scenario: [GUE002] Get User Education with Valid ID
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Get user education with valid id
    When Send request get user education with education id
    Then Status code should be 200
    And Response body message was "successfully get detail education"

  @JobSeeker
  Scenario: [UUE001] Update user education with valid id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Put user education with json "UUE001.json" and valid id
    When Send request put user education
    Then Status code should be 200
    And Response body message was "successfully update education"
    And Validate json schema "MessageSchema.json"

  @JobSeeker
  Scenario: [DUE001] Delete user education with valid id
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Get user education with valid id
    When Send request delete user education
    Then Status code should be 200
    And Response body message was "successfully delete education"
    And Validate json schema "MessageSchema.json"

#  @JobSeeker
#  Scenario: [PUE001] Post user education
#    Given User login with json file "LGJ001.json"
#    When Send request post login job seeker with valid data
#    Given Post user education with json "PUE001.json"
#    When Send request post user education
#    Then Status code should be 200
#    And Response body message was "successfully create education"