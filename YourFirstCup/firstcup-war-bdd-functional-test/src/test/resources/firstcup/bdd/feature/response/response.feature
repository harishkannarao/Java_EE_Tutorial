Feature: Response Page

  Scenario Outline: should display average age difference of all users
    Given I am on greeting page
    When I enter birthday as <dateOfBirth>
    When I click on submit
    Then The average age difference should be displayed
  Examples:
    | dateOfBirth |
    | 05/23/1993  |
    
  Scenario: should display average age difference of all users using fixtures reset
    When I reset the fixtures
    Given I am on greeting page
    When I enter birthday as 05/23/1993
    When I click on submit
    Then The average age difference should be displayed as 2.0
    When I click back button on response page
    When I enter birthday as 05/23/1997
    When I click on submit
    Then The average age difference should be displayed as 0.0
    When I click back button on response page
    When I enter birthday as 05/23/1998
    When I click on submit
    Then The average age difference should be displayed as -1.0

