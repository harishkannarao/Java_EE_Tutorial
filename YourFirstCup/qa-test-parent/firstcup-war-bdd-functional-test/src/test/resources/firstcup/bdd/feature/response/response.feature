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
    Given I reset the fixtures
    And I am on greeting page
    When I enter birthday as 05/23/1993
    And I click on submit
    Then The average age difference should be displayed as 2.0
    When I click back button on response page
    And I enter birthday as 05/23/1997
    And I click on submit
    Then The average age difference should be displayed as 0.0
    When I click back button on response page
    And I enter birthday as 05/23/1998
    And I click on submit
    Then The average age difference should be displayed as -1.0
    And I reset the fixtures

