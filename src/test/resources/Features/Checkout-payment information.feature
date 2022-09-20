@Checkout@PaymentInformation
Feature: Checkout

  @PositiveCase
  Scenario Outline: user success checkout using registered account
    Given user login with Email"qwerty@qwerty.com"and password"qwerty"
    When user choose the hotel
    And date check in"12""8""2022"
    And date check out"13""8""2022"
    And choose room
    And proceed to checkout
    Then show total amount that have to pay

  @PositiveCase
  Scenario Outline: user success checkout using new account
    Given user order room
    And date check in"12""8""2022"
    And date check out"13""8""2022"
    And choose room
    And proceed to checkout
    When user create an Account after checkout
    And input First Name in Quick Order"Dan"
    And input Last Name in Quick Order"das"
    And user input Email in Quick Order"qwerty60010@qwerty.com"
    And input Password in Quick Order"qwerty"
    And input Mobile Number in Quick Order"0888123456789"
    Then Show payment and guest information

  @PositiveCase
  Scenario Outline: user success checkout when choose more than 1 room
    Given user login with Email"qwerty@qwerty.com"and password"qwerty"
    When user choose the hotel
    And date check in"12""8""2022"
    And date check out"13""8""2022"
    And choose room
    And Continue shopping
    And choose second room
    And checkout
    Then show total amount for rooms

  @PositiveCase
  Scenario Outline: user success checkout when choose same room in different date
    Given user login with Email"qwerty@qwerty.com"and password"qwerty"
    When user choose the hotel
    And date check in"12""8""2022"
    And date check out"13""8""2022"
    And choose room
    And Continue shopping
    And date check in"19""8""2022"
    And date check out"20""8""2022"
    And choose room
    And checkout
    Then show total amount for different date

  @PositiveCase
  Scenario Outline: user success remove room in cart
    Given user login with Email"qwerty@qwerty.com"and password"qwerty"
    When user choose the hotel
    And date check in"12""8""2022"
    And date check out"13""8""2022"
    And choose room
    And Continue shopping
    And choose second room
    And remove one room
    And checkout
    Then show total amount after remove room




