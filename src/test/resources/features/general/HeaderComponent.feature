Feature: Header Component
  As a user
  I want to see consistent header elements across pages
  So that I can navigate the app easily

  Background:
    Given the app is launched

  @smoke @header
  Scenario: Verify header elements on catalog page with sort button
    Given I am on the catalog page
    Then the header should be visible
    And all main header elements should be visible
    And the menu button should be visible in header
    And the page title should be visible in header
    And the cart button should be visible in header
    And the sort button should be visible in header

  @header
  Scenario: Verify sort button only appears on catalog page
    Given I am on the catalog page
    Then the sort button should be visible in header
    And all main header elements should be visible
    And all header buttons should be clickable in header


