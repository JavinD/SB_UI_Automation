Feature: User Login
  As a user
  I want to login to the application
  So that I can proceed to checkout

  Background:
    Given the app is launched
    And I am on the catalog page
    When I click on the first product
    And I am on the product detail page
    And I set quantity to 2
    And I click add to cart button
    And I navigate to cart page
    And I am on the cart page
    And I click the checkout button
    Then I should be on the login page

  @smoke @login
  Scenario: Verify login page elements are visible
    Then all login page elements should be visible
    And the login button should be visible
    And the login button should be clickable

  @smoke @login @validlogin
  Scenario: Verify successful login with valid credentials from config
    When I enter username "from_config"
    And I enter password "from_config"
    And I click the login button
    Then I should be on the shipping info page
    And the shipping info title should be visible

  @login @validlogin
  Scenario: Verify login with valid credentials redirects to shipping info
    When I login with username "from_config" and password "from_config"
    Then I should be on the shipping info page

  @login @validlogin
  Scenario: Verify login with explicit valid credentials
    When I enter username "bob@example.com"
    And I enter password "10203040"
    And I click the login button
    Then I should be on the shipping info page

  @login @invalidlogin
  Scenario: Verify login fails when username is empty
    When I leave username empty
    And I enter password "testpass123"
    And I click the login button
    Then I should remain on the login page

  @login @invalidlogin
  Scenario: Verify login fails when password is empty
    When I enter username "testuser"
    And I leave password empty
    And I click the login button
    Then I should remain on the login page

  @smoke @login @invalidlogin
  Scenario: Verify login fails when both username and password are empty
    When I leave username empty
    And I leave password empty
    And I click the login button
    Then I should remain on the login page
    And the username field should be empty
    And the password field should be empty

  @login
  Scenario: Verify user can clear and re-enter login credentials
    When I enter username "wronguser"
    And I enter password "wrongpass"
    And I clear all login fields
    Then the username field should be empty
    And the password field should be empty
    When I enter username "from_config"
    And I enter password "from_config"
    And I click the login button
    Then I should be on the shipping info page

  @login @validlogin
  Scenario: Verify login with config credentials using shorthand
    When I login with username "config" and password "config"
    Then I should be on the shipping info page
    And all shipping info form elements should be visible

