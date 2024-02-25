Feature: Register Job Seekers

  @JobSeeker
  Scenario: [RNJ001] Register new job seeker with valid data
    Given User register with json file "RNJ001.json"
    When Send request post register job seeker
    Then Status code should be 200
    And Response body message was "successfully registered"

  @JobSeeker
  Scenario: [RNJ002] Register new job seeker with invalid email
    Given User register with json file "RNJ002.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "please enter a valid email"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ003] Register new job seeker with empty email
    Given User register with json file "RNJ003.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "email is required"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ004] Register new job seeker with duplicate email
    Given User register with json file "RNJ004.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "duplicate entry"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ005] Register new job seeker with empty name
    Given User register with json file "RNJ005.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "please complete your dat"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ006] Register new job seeker with empty username
    Given User register with json file "RNJ006.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "please complete your data"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ007] Register new job seeker with duplicate username
    Given User register with json file "RNJ007.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "duplicate entry"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ008] Register new job seeker with empty password
    Given User register with json file "RNJ008.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "please complete your data"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ009] Register new job seeker with name contains numerical
    Given User register with json file "RNJ009.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "your name is not valid"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ010] Register new job seeker with name contains special characters
    Given User register with json file "RNJ010.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "your name is not valid"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ011] Register new job seeker with password less than 8 characters
    Given User register with json file "RNJ011.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "your password is not valid"
    And Validate json schema "RegisterFailedSchema.json"

  @JobSeeker
  Scenario: [RNJ012] Register new job seeker with password equals to 8 characters
    Given User register with json file "RNJ012.json"
    When Send request post register job seeker
    Then Status code should be 200
    And Response body message was "successfully registered"

  @JobSeeker
  Scenario: [RNJ013] Register new job seeker with password more than 8 characters
    Given User register with json file "RNJ013.json"
    When Send request post register job seeker
    Then Status code should be 200
    And Response body message was "successfully registered"

  @JobSeeker
  Scenario: [RNJ014] Register new job seeker with empty all fields
    Given User register with json file "RNJ014.json"
    When Send request post register job seeker
    Then Status code should be 400
    And Response body message was "email is required"
    And Validate json schema "RegisterFailedSchema.json"

