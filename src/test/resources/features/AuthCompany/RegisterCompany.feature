Feature: Register Company

  Scenario: [RNC001] Register new company with valid data
    Given Company register with json file "RNC001.json"
    When Send request post register company
    Then Status code should be 200
    And Response body message was "successfully registered"

  Scenario: [RNC002] Register new company with invalid email
    Given Company register with json file "RNC002.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message was "successfully registered"

  Scenario: [RNC003] Register new company with empty email
    Given Company register with json file "RNC003.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC004] Register new company with duplicate email
    Given Company register with json file "RNC004.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNJ005] Register new company with empty name
    Given Company register with json file "RNC005.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC006] Register new company with empty username
    Given Company register with json file "RNC006.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC007] Register new company with name contains special characters
    Given Company register with json file "RNC007.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC008] Register new company with password less than 8 characters
      Given Company register with json file "RNC008.json"
      When Send request post register company
      Then Status code should be 400
      And Response body message contain "error insert data"

  Scenario: [RNC009] Register new company with password equals to 8 characters
    Given Company register with json file "RNC009.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC010] Register new company with password more than 8 characters
    Given Company register with json file "RNC010.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC011] Register new company with invalid website
    Given Company register with json file "RNC011.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC012] Register new company with empty website
    Given Company register with json file "RNC012.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"

  Scenario: [RNC013] Register new company with empty all fields
    Given Company register with json file "RNC013.json"
    When Send request post register company
    Then Status code should be 400
    And Response body message contain "error insert data"