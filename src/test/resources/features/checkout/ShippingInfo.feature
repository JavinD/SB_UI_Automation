Feature: Shipping Information
  As a user
  I want to enter my shipping information
  So that I can proceed to payment

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

  @smoke @checkout @shippinginfo @positive
  Scenario: Successfully fill all required fields and proceed to payment
    When I enter full name "John Doe"
    And I enter address line 1 "123 Main Street"
    And I enter city "New York"
    And I enter zip code "10001"
    And I enter country "United States"
    And I click the payment button
    Then I should be on the payment page

  @checkout @shippinginfo @negative
  Scenario: Cannot proceed to payment when required field is empty
    When I enter full name "Jane Smith"
    And I enter address line 1 "456 Oak Avenue"
    And I enter city "Los Angeles"
    And I enter zip code "90001"
    # Country field left empty intentionally
    And I click the payment button
    Then I should be on the shipping info page
