Feature: Greeting Page
  
  Scenario: should display dukes age
    Given I am on greeting page
    Then Dukes age should be displayed
    
  Scenario: should display older message for date 2 years before duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/23/1993
    When I click on submit
    Then Message should be displayed as You are 2 years older than Duke!

  Scenario: should display older message for date 1 year and 1 day before duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/22/1994
    When I click on submit
    Then Message should be displayed as You are 1 year older than Duke!
    
  Scenario: should display older message for date 1 year before duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/23/1994
    When I click on submit
    Then Message should be displayed as You are 1 year older than Duke!

  Scenario: should display same year message for date 1 day before duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/22/1995
    When I click on submit
    Then Message should be displayed as You are the same age as Duke!

  Scenario: should display same year message for date same as duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/23/1995
    When I click on submit
    Then Message should be displayed as You are the same age as Duke!

  Scenario: should display same year message for date 1 day after duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/24/1995
    When I click on submit
    Then Message should be displayed as You are the same age as Duke!

  Scenario: should display older message for date 1 year after duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/23/1996
    When I click on submit
    Then Message should be displayed as You are 1 year younger than Duke!

  Scenario: should display older message for date 1 year and 1 day after duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/24/1996
    When I click on submit
    Then Message should be displayed as You are 1 year younger than Duke!

  Scenario: should display older message for date 2 years after duke's birthday
    Given I am on greeting page
    When I enter birthday as 05/23/1997
    When I click on submit
    Then Message should be displayed as You are 2 years younger than Duke!