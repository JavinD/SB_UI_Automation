Feature: Shopping Cart
  As a user
  I want to manage items in my cart
  So that I can review and adjust my order before checkout

  Background:
    Given the app is launched

  @smoke @cart
  Scenario: Verify empty cart displays correct message
    When I navigate to cart page
    Then I am on the cart page
    And the cart should be empty
    And I should see the empty cart message
    And the checkout button should NOT be visible

  @cart
  Scenario: Verify cart displays items after adding from product detail
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 2
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the cart should have items
    And I should see 1 item in the cart
    And the quantity of the first item should be 2

  @cart @quantity
  Scenario: Verify increasing quantity in cart
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I increase quantity by 1
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the quantity of the first item should be 2
    When I click the plus button for the first item in cart
    Then the cart item quantity should increase to 3
    When I click the plus button for the first item in cart
    Then the cart item quantity should increase to 4

  @cart @quantity
  Scenario: Verify decreasing quantity in cart
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 5
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the quantity of the first item should be 5
    When I click the minus button for the first item in cart
    Then the cart item quantity should decrease to 4
    When I decrease the first item quantity by 2
    Then the quantity of the first item should be 2

  @cart @remove
  Scenario: Verify removing item when quantity is 1 by clicking minus
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the quantity of the first item should be 1
    When I click the minus button for the first item in cart
    Then the cart should be empty
    And I should see the empty cart message

  @smoke @cart @remove
  Scenario: Verify removing item immediately with remove button
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 5
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the quantity of the first item should be 5
    When I click the remove button for the first item
    Then the cart should be empty
    And I should see the empty cart message

  @cart
  Scenario: Verify all cart controls are visible for cart items
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the cart should have items
    And all cart item controls should be visible for the first item

  @smoke @cart @checkout
  Scenario: Verify checkout button is visible with items in cart
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the cart should have items
    And the checkout button should be visible
    And the checkout button should be clickable

  @cart @checkout
  Scenario: Verify checkout redirects to login page
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 3
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the checkout button should be visible
    When I click the checkout button
    Then I should be redirected to the login page

  @cart
  Scenario: Verify multiple items can be added to cart
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 2
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the total quantity in cart should be 2
    When I increase the first item quantity by 3
    Then the total quantity in cart should be 5

  @cart @remove
  Scenario: Verify removing all items returns to empty cart state
    Given I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 3
    And I click add to cart button
    And I navigate to cart page
    Then I am on the cart page
    And the cart should have items
    When I remove all items from cart
    Then the cart should be empty
    And I should see the empty cart message

