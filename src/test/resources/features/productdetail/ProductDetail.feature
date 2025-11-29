Feature: Product Detail Page
  As a user
  I want to view product details and adjust quantity
  So that I can add the desired amount to my cart

  Background:
    Given the app is launched
    And I am on the catalog page
    When I click on the first product
    And I am on the product detail page

  @smoke @productdetail
  Scenario: Verify product detail page elements are visible
    Then all product detail elements should be visible
    And the default quantity should be 1

  @productdetail @quantity
  Scenario: Verify quantity increases when clicking plus button
    Given the default quantity should be 1
    When I click the plus button
    Then the product detail quantity should increase to 2
    When I click the plus button
    Then the product detail quantity should increase to 3

  @productdetail @quantity
  Scenario: Verify quantity decreases when clicking minus button
    Given the default quantity should be 1
    When I increase quantity by 3
    Then the quantity should be 4
    When I click the minus button
    Then the product detail quantity should decrease to 3
    When I click the minus button
    Then the product detail quantity should decrease to 2

  @productdetail @quantity
  Scenario: Verify quantity changes correctly with multiple clicks
    Given the default quantity should be 1
    When I increase quantity by 5
    Then the quantity should be 6
    When I decrease quantity by 3
    Then the quantity should be 3

  @productdetail @quantity
  Scenario: Verify quantity cannot go below zero
    Given the default quantity should be 1
    When I decrease quantity by 5
    Then the quantity should be 0

  @productdetail @addtocart
  Scenario: Verify add to cart button is not clickable when quantity is 0
    Given the default quantity should be 1
    When I set quantity to 0
    Then the quantity should be 0
    And the add to cart button should NOT be clickable

  @productdetail @addtocart
  Scenario: Verify add to cart button is clickable when quantity is greater than 0
    Given the default quantity should be 1
    Then the add to cart button should be clickable
    When I increase quantity by 2
    Then the add to cart button should be clickable

  @smoke @productdetail @addtocart @cartbadge
  Scenario: Verify cart badge updates after adding items to cart
    Given the default quantity should be 1
    And the cart badge should NOT be visible
    When I increase quantity by 2
    Then the quantity should be 3
    When I click add to cart button
    Then the cart badge should be visible
    And the cart badge should show 3

  @productdetail @addtocart @cartbadge
  Scenario: Verify cart badge accumulates items from multiple additions
    Given the default quantity should be 1
    When I set quantity to 2
    And I click add to cart button
    Then the cart badge should show 2
    When I set quantity to 3
    And I click add to cart button
    Then the cart badge count should increase by the added quantity

  @productdetail @addtocart @cartbadge
  Scenario: Verify adding different quantities to cart
    Given the default quantity should be 1
    When I set quantity to 5
    Then the quantity should be 5
    When I click add to cart button
    Then the cart badge should be visible
    And the cart badge should show 5

