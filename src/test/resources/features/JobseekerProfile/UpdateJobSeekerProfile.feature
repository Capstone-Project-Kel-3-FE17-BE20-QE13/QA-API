Feature: Update Job Seeker Profile

  @JobSeeker
  Scenario: [UUP001] Update user full name
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP001.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"
    And Validate json schema "UUP001Schema.json"

  @JobSeeker
  Scenario: [UUP005] Update user username
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP005.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [UUP006] Update user username with username has been used
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP006.json"
    When Send request put update job seeker
    Then Status code should be 400

  @JobSeeker
  Scenario: [UUP007] Update user phone with valid number
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP007.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [UUP008] Update user phone with letters
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP008.json"
    When Send request put update job seeker
    Then Status code should be 400

  @JobSeeker
  Scenario: [UUP009] Update user gender
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Update job seeker with json "UUP009.json"
    When Send request put update job seeker
    Then Status code should be 200
    And Response body message was "successfully update profile"

#  @JobSeeker
#  Scenario: [UUP010] Update all user profile
#    Given User login with json file "LGJ001.json"
#    When Send request post login job seeker with valid data
#    Given Update job seeker with json "UUP010.json"
#    When Send request put update job seeker
#    Then Status code should be 200
#    And Response body message was "successfully update profile"

  @JobSeeker
  Scenario: [GUP001] Get details user profile
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker with valid data
    Given Get details user profile
    When Send request get user profile
    Then Status code should be 200