Feature: Job Seeker Education

  @JobSeeker
  Scenario: [PUE001] Post user education
    Given Post user education with json "PUE001.json"
    When Send request post user education
    Then Status code should be 200
    And Response body message was "successfully create education"

  @JobSeeker
  Scenario: [GUE001] Get all user educations
    Given Get all user educations
    When Send request get all user educations
    Then Status code should be 200
    And Response body message was "successfully get all educations"

  @JobSeeker
  Scenario: [GUE002] Get User Education with Valid ID
    Given Get user education with valid id
    When Send request get user education with education id
    Then Status code should be 200
    And Response body message was "successfully get detail education"

  @JobSeeker
  Scenario: [UUE001] Update user education with valid id
    Given Put user education with json "UUE001.json" and valid id
    When Send request put user education
    Then Status code should be 200
    And Response body message was "successfully update education"

  @JobSeeker
  Scenario: [DUE001] Delete user education with valid id
    Given Get user education with valid id
    When Send request delete user education
    Then Status code should be 200
    And Response body message was "successfully delete education"