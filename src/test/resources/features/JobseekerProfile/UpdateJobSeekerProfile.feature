Feature: Update Job Seeker Profile

  @JobSeeker
  Scenario: [UUP001] Update user full name
    Given Update job seeker with json "UUP001.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"
    And Validate json schema "UUP001Schema.json"

  @JobSeeker
  Scenario: [UUP002] Update user email
    Given Update job seeker with json "UUP002.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

#  Scenario: [UUP003] Update user password
#    Given Update job seeker with json "UUP003.json"
#    When Send request put update job seeker
#    Then Status code should be 200
#    And Response body message was "successfully update profile"
#
#  Scenario: [UUP004] Update user password with empty password
#    Given Update job seeker with json "UUP004.json"
#    When Send request put update job seeker
#    Then Status code should be 400

  @JobSeeker
  Scenario: [UUP005] Update user username
    Given Update job seeker with json "UUP005.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [UUP006] Update user username with username has been used
    Given Update job seeker with json "UUP006.json"
    When Send request put update job seeker
    Then Status code should be 400

  @JobSeeker
  Scenario: [UUP007] Update user phone with valid number
    Given Update job seeker with json "UUP007.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [UUP008] Update user phone with letters
    Given Update job seeker with json "UUP008.json"
    When Send request put update job seeker
    Then Status code should be 400

  @JobSeeker
  Scenario: [UUP009] Update user gender
    Given Update job seeker with json "UUP009.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

#  Scenario: [UUP010] Update all user profile
#    Given Update job seeker with json "UUP010.json"
#    When Send request put update job seeker
#    Then Status code should be 200
#    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [GUP001] Get details user profile
    Given Get details user profile
    When Send request get user profile
    Then Status code should be 200