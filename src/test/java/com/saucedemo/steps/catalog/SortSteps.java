package com.saucedemo.steps.catalogpage;

import com.saucedemo.pages.catalogpage.CatalogPage;
import com.saucedemo.pages.catalogpage.SortModal;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Step definitions for Sort functionality on Catalog Page
 * Tests sorting by name and price in ascending/descending order
 */
public class SortSteps {

    private CatalogPage catalogPage;
    private SortModal sortModal;

    @When("I click on the sort button on catalog page")
    public void iClickOnTheSortButtonOnCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        catalogPage.clickSortButton();
        System.out.println("Clicked on sort button");
        
        // Wait for modal to appear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the sort modal should be displayed")
    public void theSortModalShouldBeDisplayed() {
        sortModal = new SortModal();
        boolean isDisplayed = sortModal.isSortModalDisplayed();
        Assert.assertTrue("Sort modal is not displayed", isDisplayed);
        System.out.println("Sort modal is displayed");
    }

    @Then("all sort options should be visible")
    public void allSortOptionsShouldBeVisible() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        boolean allVisible = sortModal.areAllSortOptionsVisible();
        Assert.assertTrue("Not all sort options are visible", allVisible);
        System.out.println("All sort options are visible");
    }

    @When("I select sort by name ascending")
    public void iSelectSortByNameAscending() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        sortModal.clickSortNameAscending();
    }

    @When("I select sort by name descending")
    public void iSelectSortByNameDescending() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        sortModal.clickSortNameDescending();
    }

    @When("I select sort by price ascending")
    public void iSelectSortByPriceAscending() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        sortModal.clickSortPriceAscending();
    }

    @When("I select sort by price descending")
    public void iSelectSortByPriceDescending() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        sortModal.clickSortPriceDescending();
    }

    @Then("products should be sorted by name in ascending order")
    public void productsShouldBeSortedByNameInAscendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualTitles = catalogPage.getAllProductTitles();
        List<String> expectedTitles = new ArrayList<>(actualTitles);
        Collections.sort(expectedTitles, String.CASE_INSENSITIVE_ORDER);
        
        System.out.println("Actual order: " + actualTitles);
        System.out.println("Expected order: " + expectedTitles);
        
        Assert.assertEquals("Products are not sorted by name ascending", expectedTitles, actualTitles);
        System.out.println("Products are correctly sorted by name in ascending order");
    }

    @Then("products should be sorted by name in descending order")
    public void productsShouldBeSortedByNameInDescendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualTitles = catalogPage.getAllProductTitles();
        List<String> expectedTitles = new ArrayList<>(actualTitles);
        Collections.sort(expectedTitles, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(expectedTitles);
        
        System.out.println("Actual order: " + actualTitles);
        System.out.println("Expected order: " + expectedTitles);
        
        Assert.assertEquals("Products are not sorted by name descending", expectedTitles, actualTitles);
        System.out.println("Products are correctly sorted by name in descending order");
    }

    @Then("products should be sorted by price in ascending order")
    public void productsShouldBeSortedByPriceInAscendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualPrices = catalogPage.getAllProductPrices();
        List<Double> actualPriceValues = new ArrayList<>();
        
        // Convert prices to double for comparison
        for (String price : actualPrices) {
            actualPriceValues.add(catalogPage.parsePriceToDouble(price));
        }
        
        List<Double> expectedPriceValues = new ArrayList<>(actualPriceValues);
        Collections.sort(expectedPriceValues);
        
        System.out.println("Actual prices: " + actualPriceValues);
        System.out.println("Expected prices: " + expectedPriceValues);
        
        Assert.assertEquals("Products are not sorted by price ascending", expectedPriceValues, actualPriceValues);
        System.out.println("Products are correctly sorted by price in ascending order");
    }

    @Then("products should be sorted by price in descending order")
    public void productsShouldBeSortedByPriceInDescendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualPrices = catalogPage.getAllProductPrices();
        List<Double> actualPriceValues = new ArrayList<>();
        
        // Convert prices to double for comparison
        for (String price : actualPrices) {
            actualPriceValues.add(catalogPage.parsePriceToDouble(price));
        }
        
        List<Double> expectedPriceValues = new ArrayList<>(actualPriceValues);
        Collections.sort(expectedPriceValues);
        Collections.reverse(expectedPriceValues);
        
        System.out.println("Actual prices: " + actualPriceValues);
        System.out.println("Expected prices: " + expectedPriceValues);
        
        Assert.assertEquals("Products are not sorted by price descending", expectedPriceValues, actualPriceValues);
        System.out.println("Products are correctly sorted by price in descending order");
    }
}

