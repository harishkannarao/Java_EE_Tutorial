@2015.02
@2015.06
Feature: Greeting Page
  @Story123
  Scenario: should display dukes age
    Given I am on greeting page
    Then Dukes age should be displayed
    
  Scenario Outline: should display age difference message
    Given I am on greeting page
    When I enter birthday as <dob>
    When I click on submit
    Then Message should be displayed as <message>
  Examples:
    | dob         | message                             |
    | 05/23/1993  | You are 2 years older than Duke!    |
    | 05/22/1994  | You are 1 year older than Duke!     |
    | 05/23/1994  | You are 1 year older than Duke!     |
    | 05/22/1995  | You are the same age as Duke!       |
    | 05/23/1995  | You are the same age as Duke!       |
    | 05/24/1995  | You are the same age as Duke!       |
    | 05/23/1996  | You are 1 year younger than Duke!   |
    | 05/24/1996  | You are 1 year younger than Duke!   |
    | 05/23/1997  | You are 2 years younger than Duke!  |