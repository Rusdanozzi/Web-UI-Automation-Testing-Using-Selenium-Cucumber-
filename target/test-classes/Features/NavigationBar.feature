@NavigationBar
Feature: Function navigation bar

  @PositiveCase
  Scenario Outline: user success open Home
    Given user success access website
    When user click home
    Then show home of website

  @PositiveCase
  Scenario Outline: user success open Interior
    Given user success access website
    When user click interior
    Then show interior of website

  @PositiveCase
  Scenario Outline: user success open Amenties
    Given user success access website
    When user click amenties
    Then show amenties of website

  @PositiveCase
  Scenario Outline: user success open Rooms
    Given user success access website
    When user click rooms
    Then show rooms of website

  @PositiveCase
  Scenario Outline: user success open Testimonials
    Given user success access website
    When user click testimonials
    Then show testimonial of website

  @PositiveCase
  Scenario Outline: user success open Legal Notice
    Given user success access website
    When user click legal notice
    Then show legal notice of website

  @PositiveCase
  Scenario Outline: user success open About us
    Given user success access website
    When user click about us
    Then show about us of website

  @PositiveCase
  Scenario Outline: user success open Contact
    Given user success access website
    When user click contact
    Then show contact of website
