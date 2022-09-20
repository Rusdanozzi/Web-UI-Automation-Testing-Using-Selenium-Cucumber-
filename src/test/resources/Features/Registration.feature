@Registration
Feature: Registration Using email

  @PositiveCase
  Scenario Outline: user success Create account in login page
    Given user has accessed login page
    When user input email"qwerty7000030@gmail.com"
    And Choose Title"Mr"
    And input First Name"Paijo"
    And input Last Name"Budi"
    And input Password"qwerty"
    And input Date of Birth"21""4""1997"
    Then User should be directed to My Account page

  @NegativeCase
  Scenario Outline: user fail Create account using registered Email
    Given user has accessed login page
    When user input email"qwerty@qwerty.com"
    Then show eror alert

  @NegativeCase
  Scenario Outline: user fail Create account in login page with password less than 5 letter
    Given user has accessed login page
    When user input email"qwerty700099@gmail.com"
    And Choose Title"Mr"
    And input First Name"Paijo"
    And input Last Name"Budi"
    And input Password"qwer"
    And input Date of Birth"21""4""1997"
    Then Show Password is invalid

