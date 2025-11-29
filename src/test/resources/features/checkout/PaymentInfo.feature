Feature: Payment Information
  As a user
  I want to enter my payment information
  So that I can complete my purchase

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

  @smoke @checkout @paymentinfo @positive
  Scenario: Successfully fill all payment fields and proceed to checkout review
    When I enter cardholder name "John Doe"
    And I enter card number "1234567890123456"
    And I enter expiration date "1225"
    And I enter security code "123"
    And I click the review order button
    Then I should be on the checkout info page

  @checkout @paymentinfo @negative
  Scenario: Cannot proceed when required payment field is empty
    When I enter cardholder name "Jane Smith"
    And I enter card number "9876543210987654"
    And I enter expiration date "0526"
    # Security code left empty intentionally
    And I click the review order button
    Then I should be on the payment info page

