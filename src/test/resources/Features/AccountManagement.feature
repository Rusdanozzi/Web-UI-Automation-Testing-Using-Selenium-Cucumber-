@AccountManagement
Feature: Edit personal information

  @PositiveCase
  Scenario Outline: user success add a new address
    Given user access My Account page
    When user set Email"qwerty75@qwerty.com"
    And User set password"qwerty75"
    And user access My Addresses
    And user add a new address
    And input Company"SQA"
    And input address"Kebayoran baru, Jakarta Selatan"
    And input city"Jakarta"
    And input state"Washington"
    And input zip code"12121"
    And input home phone"0271717171"
    And input mobile phone"088123456789"
    And input address title"Company"
    Then new address has added

  @PositiveCase
  Scenario Outline: user success delete address
    Given user access My Account page
    When user set Email"qwerty75@qwerty.com"
    And User set password"qwerty75"
    And user access My Addresses
    And delete address
    Then address has been deleted

  @PositiveCase
  Scenario Outline: user success change First and last name
    Given user access My Account page
    When user set Email"qwerty75@qwerty.com"
    And User set password"qwerty75"
    And user access My Personal Information
    And user change first name"Fahrur"
    And user change last name"Ozzi"
    And user input password"qwerty75"
    Then personal information has been changed

  @PositiveCase
  Scenario Outline: user success change date of birth
    Given user access My Account page
    When user set Email"qwerty75@qwerty.com"
    And User set password"qwerty75"
    And user access My Personal Information
    And user change date of birth"22""5""1999"
    And user input password"qwerty75"
    Then personal information has been changed

  @PositiveCase
  Scenario Outline: user success change email
    Given user access My Account page
    When user set Email"qwerty75@qwerty.com"
    And User set password"qwerty75"
    And user access My Personal Information
    And user change email"qwerty76@qwerty.com"
    And user input password"qwerty75"
    Then personal information has been changed

  @PositiveCase
  Scenario Outline: user success change password
    Given user access My Account page
    When user set Email"qwerty76@qwerty.com"
    And User set password"qwerty75"
    And user access My Personal Information
    And user input password"qwerty75"
    And user input new password"qwerty76"
    Then personal information has been changed