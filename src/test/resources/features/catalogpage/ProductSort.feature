Feature: Product Sorting
  As a user
  I want to sort products by name and price
  So that I can find products more easily

  Background:
    Given the app is launched
    And I am on the catalog page

  @smoke @sort
  Scenario: Verify sort modal displays with all options
    When I click on the sort button on catalog page
    Then the sort modal should be displayed
    And all sort options should be visible


  @sort
  Scenario: Verify all sorting options work correctly
    When I click on the sort button on catalog page
    Then the sort modal should be displayed
    When I select sort by name ascending
    Then products should be sorted by name in ascending order

    When I click on the sort button on catalog page
    And I select sort by name descending
    Then products should be sorted by name in descending order
    
    When I click on the sort button on catalog page
    And I select sort by price ascending
    Then products should be sorted by price in ascending order
    
    When I click on the sort button on catalog page
    And I select sort by price descending
    Then products should be sorted by price in descending order


