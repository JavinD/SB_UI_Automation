package com.saucedemo.steps.catalog;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import com.saucedemo.pages.catalog.CatalogPage;

public class CatalogPageSteps {

    private CatalogPage catalogPage;

    @Given("I am on the catalog page")
    public void iAmOnTheCatalogPage() {
        catalogPage = new CatalogPage();
        boolean isDisplayed = catalogPage.isCatalogPageDisplayed();
        Assert.assertTrue("Catalog page is not displayed", isDisplayed);
    }

    @Then("all catalog page elements should be visible")
    public void allCatalogPageElementsShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean allHeaderVisible = catalogPage.areMainHeaderElementsVisible();
        boolean sortVisible = catalogPage.isSortButtonVisible();
        int productCount = catalogPage.getProductCount();
        
        Assert.assertTrue("Header elements are not visible", allHeaderVisible);
        Assert.assertTrue("Sort button is not visible", sortVisible);
        Assert.assertTrue("No products displayed", productCount > 0);
    }

    @Then("the page title should display {string}")
    public void thePageTitleShouldDisplay(String expectedTitle) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        String actualTitle = catalogPage.getPageTitle();
        Assert.assertEquals("Page title does not match", expectedTitle, actualTitle);
    }

    @Then("I should see at least {int} products")
    public void iShouldSeeAtLeastProducts(int expectedCount) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        int actualCount = catalogPage.getProductCount();
        Assert.assertTrue("Expected at least " + expectedCount + " products, but found " + actualCount, 
                         actualCount >= expectedCount);
    }

    @Then("each product should have title, price and rating")
    public void eachProductShouldHaveTitlePriceAndRating() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        int productCount = Math.min(catalogPage.getProductCount(), 3);
        
        for (int i = 0; i < productCount; i++) {
            String title = catalogPage.getProductTitle(i);
            String price = catalogPage.getProductPrice(i);
            String rating = catalogPage.getProductRating(i);
            
            Assert.assertFalse("Product " + i + " title is empty", title.isEmpty());
            Assert.assertFalse("Product " + i + " price is empty", price.isEmpty());
            Assert.assertFalse("Product " + i + " rating is empty", rating.equals("0 stars"));
        }
    }

    @When("I click on the first product")
    public void iClickOnTheFirstProduct() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickOnFirstProduct();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on product at index {int}")
    public void iClickOnProductAtIndex(int index) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickOnProductImage(index);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the sort button")
    public void iClickOnTheSortButton() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickSortButton();
    }

    @Then("the sort button should be visible")
    public void theSortButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean sortVisible = catalogPage.isSortButtonVisible();
        Assert.assertTrue("Sort button is not visible", sortVisible);
    }

    @Then("the menu button should be visible")
    public void theMenuButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean menuVisible = catalogPage.isMenuButtonVisible();
        Assert.assertTrue("Menu button is not visible", menuVisible);
    }

    @Then("the cart button should be visible")
    public void theCartButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean cartVisible = catalogPage.isCartButtonVisible();
        Assert.assertTrue("Cart button is not visible", cartVisible);
    }

    @Then("all header buttons should be clickable")
    public void allHeaderButtonsShouldBeClickable() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean headerButtonsClickable = catalogPage.areHeaderButtonsClickable();
        boolean sortClickable = catalogPage.isSortButtonClickable();
        
        Assert.assertTrue("Header buttons (menu, cart) are not clickable", headerButtonsClickable);
        Assert.assertTrue("Sort button is not clickable", sortClickable);
    }
}
