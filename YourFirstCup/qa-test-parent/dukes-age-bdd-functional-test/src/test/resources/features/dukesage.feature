Feature: Dukes Age Resource

  Scenario: get dukes age
    Given Url as /dukes-age/webapi/dukesAge
    When I make a GET request
    Then Status should be 200
    And Should return correct dukes age

  Scenario: get dukes age again to test Before annotation
    Given Url as /dukes-age/webapi/dukesAge
    When I make a GET request
    Then Status should be 200
    And Should return correct dukes age