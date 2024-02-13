Feature: Job Seeker Career

  @Test
  Scenario: [PUC001] Post user career
    Given Post user career with json "PUC001.json"
    When Send request post user career
    Then Status code should be 200
    And Response body message was "successfully create career"

  @Test
  Scenario: [GUC001] Get all user careers
    Given Get all user careers
    When Send request get all user careers
    Then Status code should be 200
    And Response body message was "successfully get all careers"

  @Test
  Scenario: [GUC002] Get User Career with Valid ID
    Given Get user career with valid id
    When Send request get user career with career id
    Then Status code should be 200
    And Response body message was "successfully get detail career"

  @Test
  Scenario: [UUC001] Update user career with valid id
    Given Put user career with json "UUC001.json" dan valid id
    When Send request put user career
    Then Status code should be 200
    And Response body message was "successfully update career"

  @Test
  Scenario: [DUC001] Delete user career with valid id
    Given Get user career with valid id
    When Send request delete user career
    Then Status code should be 200
    And Response body message was "successfully delete career"




