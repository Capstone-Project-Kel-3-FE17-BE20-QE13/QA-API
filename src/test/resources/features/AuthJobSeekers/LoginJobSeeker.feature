Feature: Login Job Seeker

  Scenario: [LGJ001] Login job seeker with valid data
    Given User login with json file "LGJ001.json"
    When Send request post login job seeker
    Then Status code should be 200
    And Response body message was "successfully login"
    And Validate json schema "LGJ001Schema.json"

  Scenario: [LGJ002] Login job seeker with wrong password
    Given User login with json file "LGJ002.json"
    When Send request post login job seeker
    Then Status code should be 400

  Scenario: [LGJ003] Login job seeker with invalid email
    Given User login with json file "LGJ003.json"
    When Send request post login job seeker
    Then Status code should be 400

  Scenario: [LGJ004] Login job seeker with wrong email
    Given User login with json file "LGJ004.json"
    When Send request post login job seeker
    Then Status code should be 400

  Scenario: [LGJ005] Login job seeker with empty email
    Given User login with json file "LGJ005.json"
    When Send request post login job seeker
    Then Status code should be 400

  Scenario: [LGJ006] Login job seeker with empty password
    Given User login with json file "LGJ006.json"
    When Send request post login job seeker
    Then Status code should be 400

  Scenario: [LGJ007] Login job seeker with empty email and password
    Given User login with json file "LGJ007.json"
    When Send request post login job seeker
    Then Status code should be 400

