Feature: Checkout Review and Order Placement
  As a user
  I want to review my order and complete the purchase
  So that I can finalize my transaction

  Background:
    Given the app is launched
    And I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I click add to cart button
    And I navigate to cart page
    And I am on the cart page
    And I click the checkout button
    And I should be on the login page
    And I login with username "from_config" and password "from_config"
    And I should be on the shipping info page
    And I enter full name "John Doe"
    And I enter address line 1 "123 Main Street"
    And I enter city "New York"
    And I enter zip code "10001"
    And I enter country "United States"
    And I click the payment button
    And I should be on the payment info page
    And I enter cardholder name "John Doe"
    And I enter card number "1234567890123456"
    And I enter expiration date "1225"
    And I enter security code "123"
    And I click the review order button
    And I should be on the checkout info page

  @smoke @checkout @checkoutinfo @e2e
  Scenario: Successfully place order and view confirmation
    When I click the place order button
    Then I should be on the checkout complete page
    And the order confirmation should be visible

