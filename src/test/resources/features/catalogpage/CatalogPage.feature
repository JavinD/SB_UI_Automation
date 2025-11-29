Feature: Catalog Page
  As a user
  I want to view the product catalog
  So that I can browse and select products

  Background:
    Given the app is launched
    And I am on the catalog page

  @smoke @catalog
  Scenario: Verify all catalog page elements are visible
    Then all catalog page elements should be visible
    And the page title should display "Products"
    And the sort button should be visible
    And the menu button should be visible
    And the cart button should be visible

  @catalog
  Scenario: Verify product list displays correctly
    Then I should see at least 5 products
    And each product should have title, price and rating

  @catalog
  Scenario: Verify header buttons are clickable
    Then all header buttons should be clickable

  @catalog
  Scenario: Verify catalog page has all required elements
    Then the page title should display "Products"
    And I should see at least 1 products
    And the sort button should be visible
    And the menu button should be visible
    And the cart button should be visible
    And all header buttons should be clickable


