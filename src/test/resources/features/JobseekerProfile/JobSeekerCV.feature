Feature: Job Seeker CV

  Scenario: Post user cv
    Given Job seeker with file "CV.pdf"
    When Send request post file
    Then Status code should be 200
    And Response body message was "successfully upload cv"

  Scenario: Get all cvs
    Given Job seeker with valid cv
    When Send request get cv
    Then Status code should be 200
    And Response body message was "successfully get cv"

  Scenario: Update user cv
    Given Job seeker with file "CV.pdf"
    When Send request put file
    Then Status code should be 200
    And Response body message was "successfully update cv"

  Scenario: Delete CV
    Given Job seeker with valid cv
    When Send request delete file
    Then Status code should be 200
    And Response body message was "successfully delete cv"
