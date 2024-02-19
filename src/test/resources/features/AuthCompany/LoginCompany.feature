Feature: Login company

  Scenario: [LGC001] Login company with valid data
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Then Status code should be 200
    And Response body message was "success login."
    And Validate json schema "LGJ001Schema.json"

  Scenario: [LGC002] Login company with wrong password
      Given Company login with json file "LGC002.json"
      When Send request post login company
      Then Status code should be 403
      And Response body message was "Email atau password tidak boleh kosong "

  Scenario: [LGC003] Login company with invalid email
    Given Company login with json file "LGC003.json"
    When Send request post login company
    Then Status code should be 403
    And Response body message was "Email atau password tidak boleh kosong "

    Scenario: [LGC004] Login company with wrong email
      Given Company login with json file "LGC004.json"
      When Send request post login company
      Then Status code should be 403
      And Response body message was "Email atau password tidak boleh kosong "

  Scenario: [LGJ005] Login company with empty email
    Given Company login with json file "LGC005.json"
    When Send request post login company
    Then Status code should be 403
    And Response body message was "Email atau password tidak boleh kosong "

  Scenario: [LGJ006] Login company with empty password
    Given Company login with json file "LGC006.json"
    When Send request post login company
    Then Status code should be 403
    And Response body message was "Email atau password tidak boleh kosong "

  Scenario: [LGJ007] Login company with empty email and password
    Given Company login with json file "LGC007.json"
    When Send request post login company
    Then Status code should be 403
    And Response body message was "Email atau password tidak boleh kosong "

