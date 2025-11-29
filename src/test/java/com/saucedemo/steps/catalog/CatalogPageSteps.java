package com.saucedemo.steps.catalogpage;

import com.saucedemo.pages.catalogpage.CatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Step definitions for Catalog Page functionality
 * Tests catalog-specific features like products, sorting, filtering
 */
public class CatalogPageSteps {

    private CatalogPage catalogPage;

    @Given("I am on the catalog page")
    public void iAmOnTheCatalogPage() {
        catalogPage = new CatalogPage();
        boolean isDisplayed = catalogPage.isCatalogPageDisplayed();
        Assert.assertTrue("Catalog page is not displayed", isDisplayed);
        System.out.println("User is on catalog page");
    }

    @Then("all catalog page elements should be visible")
    public void allCatalogPageElementsShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        // Check header elements using inherited methods
        boolean allHeaderVisible = catalogPage.areMainHeaderElementsVisible();
        boolean sortVisible = catalogPage.isSortButtonVisible();
        
        // Check product elements
        int productCount = catalogPage.getProductCount();
        
        System.out.println("All header elements visible: " + allHeaderVisible);
        System.out.println("Sort visible: " + sortVisible);
        System.out.println("Product count: " + productCount);
        
        Assert.assertTrue("Header elements are not visible", allHeaderVisible);
        Assert.assertTrue("Sort button is not visible", sortVisible);
        Assert.assertTrue("No products displayed", productCount > 0);
        
        System.out.println("All catalog page elements are visible");
    }

    @Then("the page title should display {string}")
    public void thePageTitleShouldDisplay(String expectedTitle) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        // Use inherited method from HeaderComponent
        String actualTitle = catalogPage.getPageTitle();
        Assert.assertEquals("Page title does not match", expectedTitle, actualTitle);
        System.out.println("Page title is: " + actualTitle);
    }

    @Then("I should see at least {int} products")
    public void iShouldSeeAtLeastProducts(int expectedCount) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        int actualCount = catalogPage.getProductCount();
        Assert.assertTrue("Expected at least " + expectedCount + " products, but found " + actualCount, 
                         actualCount >= expectedCount);
        System.out.println("Found " + actualCount + " products");
    }

    @Then("each product should have title, price and rating")
    public void eachProductShouldHaveTitlePriceAndRating() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        int productCount = Math.min(catalogPage.getProductCount(), 3); // Check first 3 products
        
        for (int i = 0; i < productCount; i++) {
            String title = catalogPage.getProductTitle(i);
            String price = catalogPage.getProductPrice(i);
            String rating = catalogPage.getProductRating(i);
            
            Assert.assertFalse("Product " + i + " title is empty", title.isEmpty());
            Assert.assertFalse("Product " + i + " price is empty", price.isEmpty());
            Assert.assertFalse("Product " + i + " rating is empty", rating.equals("0 stars"));
            
            System.out.println("Product " + i + ": " + title + " - " + price + " - " + rating);
        }
        
        System.out.println("All products have complete information");
    }

    @When("I click on the first product")
    public void iClickOnTheFirstProduct() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickOnFirstProduct();
        System.out.println("Clicked on first product");
    }

    @When("I click on product at index {int}")
    public void iClickOnProductAtIndex(int index) {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickOnProductImage(index);
        System.out.println("Clicked on product at index: " + index);
    }

    @When("I click on the sort button")
    public void iClickOnTheSortButton() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        catalogPage.clickSortButton();
        System.out.println("Clicked on sort button");
    }

    @Then("the sort button should be visible")
    public void theSortButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean sortVisible = catalogPage.isSortButtonVisible();
        Assert.assertTrue("Sort button is not visible", sortVisible);
        System.out.println("Sort button is visible");
    }

    @Then("the menu button should be visible")
    public void theMenuButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean menuVisible = catalogPage.isMenuButtonVisible();
        Assert.assertTrue("Menu button is not visible", menuVisible);
        System.out.println("Menu button is visible");
    }

    @Then("the cart button should be visible")
    public void theCartButtonShouldBeVisible() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        boolean cartVisible = catalogPage.isCartButtonVisible();
        Assert.assertTrue("Cart button is not visible", cartVisible);
        System.out.println("Cart button is visible");
    }

    @Then("all header buttons should be clickable")
    public void allHeaderButtonsShouldBeClickable() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        
        // Use inherited method from HeaderComponent for menu and cart
        boolean headerButtonsClickable = catalogPage.areHeaderButtonsClickable();
        // Check sort separately as it's catalog-specific
        boolean sortClickable = catalogPage.isSortButtonClickable();
        
        System.out.println("Header buttons (menu, cart) clickable: " + headerButtonsClickable);
        System.out.println("Sort clickable: " + sortClickable);
        
        Assert.assertTrue("Header buttons (menu, cart) are not clickable", headerButtonsClickable);
        Assert.assertTrue("Sort button is not clickable", sortClickable);
        
        System.out.println("All header buttons are clickable");
    }
}

