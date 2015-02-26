Feature: Response Page

#  Scenario Outline: should display average age difference of all users
#    Given I am on greeting page
#    When I enter birthday as <dateOfBirth>
#    When I click on submit
#    Then The average age difference should be displayed
#  Examples:
#    | dateOfBirth |
#    | 05/23/1993  |
  
  Scenario: should display average age difference of all users
    Given I am on greeting page
    When I enter birthday as 05/23/1993
    When I click on submit
    Then The average age difference should be displayed
