Feature: Login Job Seekers

  Scenario: [LGJ001] Login job seeker with valid data
    Given User with json file "LGJ001.json"
    When Send request post login job seeker
    Then Status code should be 200
    And Response body message was "successfully login"
    And Validate json schema "LGJ001Schema.json"

