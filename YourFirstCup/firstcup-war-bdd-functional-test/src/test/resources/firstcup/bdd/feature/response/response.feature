Feature: Response Page
  
  Scenario: should display average age difference of all users
    Given I am on greeting page
    When I enter birthday as 05/23/1993
    Then The average age difference should be calculated based on 05/23/1993