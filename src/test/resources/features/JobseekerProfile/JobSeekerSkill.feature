Feature: Job Seeker Skill

  Scenario: [PUS001] Post user skill
    Given Post user skill with json "PUS001.json"
    When Send request post user skill
    Then Status code should be 200
    And Response body message was "successfully create skill"

  Scenario: [GUS001] Get all user skills
    Given Get all user skills
    When Send request get all user skills
    Then Status code should be 200
    And Response body message was "successfully get all skills"

  Scenario: [GUS002] Get User Skill with Valid ID
    Given Get user skill with valid id
    When Send request get user skill with skill id
    Then Status code should be 200
    And Response body message was "successfully get detail skill"

  Scenario: [UUS001] Update user skill with valid id
    Given Put user skill with json "UUS001.json" and valid id
    When Send request put user skill
    Then Status code should be 200
    And Response body message was "successfully update skill"

  Scenario: [DUS001] Delete user skill with valid id
    Given Get user skill with valid id
    When Send request delete user skill
    Then Status code should be 200
    And Response body message was "successfully delete skill"