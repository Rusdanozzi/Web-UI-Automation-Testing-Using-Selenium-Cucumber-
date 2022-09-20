@Login
Feature: Login Using email

  @PositiveCase
  Scenario: user success login using valid email
    Given user access login page1
    When user input Email"qwerty@qwerty.com"
    And User input password"qwerty"
    Then User should be directed to Account page

  @NegativeCase
  Scenario Outline: user fail login using unregistered email
    Given user access login page
    When user input Email"rusdan@rusdan.com"
    And User input password"qwerty"
    Then user fail login
    And show Authentication fail

  @NegativeCase
  Scenario Outline: user fail login using wrong password
    Given user access login page
    When user input Email"qwerty@qwerty.com"
    And User input password"qwerty12"
    Then user fail login
    And show Authentication fail

  @NegativeCase
  Scenario Outline: user fail login using empty password
    Given user access login page
    When user input Email"qwerty@qwerty.com"
    And User input password""
    Then user fail login
    And show Password is Required

  @PositiveCase
  Scenario Outline: user success Logout
    Given user access login page
    When user input Email"qwerty@qwerty.com"
    And User input password"qwerty"
    And user success login
    And user Logout
    Then user success logout

  @CobaError
  Scenario: Login
    Given login page
    When Email"qwerty@qwerty.com"
    And password"qwerty"
    Then Account page
