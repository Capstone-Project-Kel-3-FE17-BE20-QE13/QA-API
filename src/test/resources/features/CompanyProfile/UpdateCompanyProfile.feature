Feature: Update Company Profile

#  Scenario Outline: Update company profile
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with form data "<image_url>" as image, "<company_name>" as company name, "<full_name>" as full name, "<address>" as address, "<phone>" as phone, "<company_size>" as company size, "<website>" as website, and "<description>" as description
#    When Send request put update company
#    Then Status code should be 200
#    And Response body message was "success."
#    Examples:
#      | image_url | company_name    | full_name | address | phone | company_size | website | description |
#      |           | company halimah |           |         |       |              |         |             |

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

#  Scenario: [UCP003] Update company full name
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP003.json"
#    When Send request put update company
#    Then Status code should be 200
#    And Response body message was "success."
#
#  Scenario: [UCP004] Update company address
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP004.json"
#    When Send request put update company
#    Then Status code should be 200
#    And Response body message was "success."
#
#  Scenario: [UCP005] Update company phone with valid number
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP005.json"
#    When Send request put update company
#    Then Status code should be 200
#    And Response body message was "success."
#
#  Scenario: [UCP006] Update company phone with letters
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP006.json"
#    When Send request put update company
#    Then Status code should be 400
#
#  Scenario: [UCP007] Update company size
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP007.json"
#    When Send request put update company
#    Then Status code should be 200
#
#  Scenario: [UCP008] Update company website
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP008.json"
#    When Send request put update company
#    Then Status code should be 200
#
#  Scenario: [UCP009] Update company description
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Given Update company with json "UCP009.json"
#    When Send request put update company
#    Then Status code should be 200
#
#  Scenario: [UCP010] Update company image url
#    Given Company login with json file "LGC001.json"
#    When Send request post login company
#    Then Update image "th.jpg"
#    Then Status code should be 200
##    Examples:
##      | image_url |
##      | foto1.jpg |

  Scenario: [GCP001] Get details user profile company
    Given Company login with json file "LGC001.json"
    When Send request post login company
    Given Get details user company
    When Send request get user profile company
    Then Status code should be 200