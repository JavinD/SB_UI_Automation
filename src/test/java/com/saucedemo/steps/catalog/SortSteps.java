package com.saucedemo.steps.catalog;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import com.saucedemo.pages.catalog.CatalogPage;
import com.saucedemo.pages.catalog.SortModal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortSteps {

    private CatalogPage catalogPage;
    private SortModal sortModal;

    @When("I click on the sort button on catalog page")
    public void iClickOnTheSortButtonOnCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        catalogPage.clickSortButton();
        
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
    }

    @Then("all sort options should be visible")
    public void allSortOptionsShouldBeVisible() {
        if (sortModal == null) {
            sortModal = new SortModal();
        }
        boolean allVisible = sortModal.areAllSortOptionsVisible();
        Assert.assertTrue("Not all sort options are visible", allVisible);
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
        
        Assert.assertEquals("Products are not sorted by name ascending", expectedTitles, actualTitles);
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
        
        Assert.assertEquals("Products are not sorted by name descending", expectedTitles, actualTitles);
    }

    @Then("products should be sorted by price in ascending order")
    public void productsShouldBeSortedByPriceInAscendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualPrices = catalogPage.getAllProductPrices();
        List<Double> actualPriceValues = new ArrayList<>();
        
        for (String price : actualPrices) {
            actualPriceValues.add(catalogPage.parsePriceToDouble(price));
        }
        
        List<Double> expectedPriceValues = new ArrayList<>(actualPriceValues);
        Collections.sort(expectedPriceValues);
        
        Assert.assertEquals("Products are not sorted by price ascending", expectedPriceValues, actualPriceValues);
    }

    @Then("products should be sorted by price in descending order")
    public void productsShouldBeSortedByPriceInDescendingOrder() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        List<String> actualPrices = catalogPage.getAllProductPrices();
        List<Double> actualPriceValues = new ArrayList<>();
        
        for (String price : actualPrices) {
            actualPriceValues.add(catalogPage.parsePriceToDouble(price));
        }
        
        List<Double> expectedPriceValues = new ArrayList<>(actualPriceValues);
        Collections.sort(expectedPriceValues);
        Collections.reverse(expectedPriceValues);
        
        Assert.assertEquals("Products are not sorted by price descending", expectedPriceValues, actualPriceValues);
    }
}
