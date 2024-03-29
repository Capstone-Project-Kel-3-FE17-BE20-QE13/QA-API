Feature: Update Company Profile

  Scenario Outline: Update company profile
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Update company with form data "<image_url>" as image, "<company_name>" as company name, "<full_name>" as full name, "<address>" as address, "<phone>" as phone, "<company_size>" as company size, "<website>" as website, and "<description>" as description
    When Send request put update company
    Then Status code should be 200
    And Response body message was "success."
    Examples:
      | image_url | company_name    | full_name | address | phone        | company_size    | website             | description |
      | foto1.jpg | company halimah | nia cinta | jakarta | 089712345678 | 1-250 employess | https://compnia.com | description |


  Scenario Outline: Update company profile full name
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Update company with form data "<full_name>" as full name
    When Send request put update company
    Then Status code should be 200
    And Response body message was "success."
    Examples:
      | full_name |
      | nia cinta |

  Scenario Outline: Update company profile address
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Update company with form data "<address>" as address
    When Send request put update company
    Then Status code should be 200
    And Response body message was "success."
    Examples:
      | address |
      | jakarta |

  Scenario: [GCP001] Get details user profile company
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Get details user company
    When Send request get user profile company
    Then Status code should be 200