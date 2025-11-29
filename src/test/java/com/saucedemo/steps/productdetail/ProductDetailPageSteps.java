package com.saucedemo.steps.productdetail;

import com.saucedemo.pages.productdetail.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Step definitions for Product Detail Page functionality
 * Tests quantity adjustment and add to cart features
 */
public class ProductDetailPageSteps {

    private ProductDetailPage productDetailPage;
    private int initialCartCount = 0;
    private int quantityBeforeAddingToCart = 0;

    @Given("I am on the product detail page")
    public void iAmOnTheProductDetailPage() {
        productDetailPage = new ProductDetailPage();
        boolean isDisplayed = productDetailPage.isProductDetailPageDisplayed();
        Assert.assertTrue("Product detail page is not displayed", isDisplayed);
        System.out.println("User is on product detail page");
    }

    @Then("all product detail elements should be visible")
    public void allProductDetailElementsShouldBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean allVisible = productDetailPage.areAllProductDetailElementsVisible();
        Assert.assertTrue("Not all product detail elements are visible", allVisible);
        System.out.println("All product detail elements are visible");
    }

    @Then("the default quantity should be {int}")
    public void theDefaultQuantityShouldBe(int expectedQuantity) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int actualQuantity = productDetailPage.getCurrentQuantity();
        Assert.assertEquals("Default quantity does not match", expectedQuantity, actualQuantity);
        System.out.println("Default quantity is: " + actualQuantity);
    }

    @When("I click the plus button")
    public void iClickThePlusButton() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        productDetailPage.clickPlusButton();
    }

    @When("I click the minus button")
    public void iClickTheMinusButton() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        productDetailPage.clickMinusButton();
    }

    @When("I increase quantity by {int}")
    public void iIncreaseQuantityBy(int times) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        productDetailPage.increaseQuantityBy(times);
    }

    @When("I decrease quantity by {int}")
    public void iDecreaseQuantityBy(int times) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        productDetailPage.decreaseQuantityBy(times);
    }

    @When("I set quantity to {int}")
    public void iSetQuantityTo(int quantity) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        productDetailPage.setQuantityTo(quantity);
    }

    @Then("the quantity should be {int}")
    public void theQuantityShouldBe(int expectedQuantity) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int actualQuantity = productDetailPage.getCurrentQuantity();
        Assert.assertEquals("Quantity does not match expected value", expectedQuantity, actualQuantity);
        System.out.println("Quantity is now: " + actualQuantity);
    }

    @Then("the product detail quantity should increase to {int}")
    public void theProductDetailQuantityShouldIncreaseTo(int expectedQuantity) {
        theQuantityShouldBe(expectedQuantity);
    }

    @Then("the product detail quantity should decrease to {int}")
    public void theProductDetailQuantityShouldDecreaseTo(int expectedQuantity) {
        theQuantityShouldBe(expectedQuantity);
    }

    @When("I click add to cart button")
    public void iClickAddToCartButton() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        // Store cart count before adding
        initialCartCount = productDetailPage.getCartBadgeCount();
        quantityBeforeAddingToCart = productDetailPage.getCurrentQuantity();
        
        System.out.println("Cart count before adding: " + initialCartCount);
        System.out.println("Quantity to add: " + quantityBeforeAddingToCart);

        productDetailPage.clickAddToCart();
    }

    @Then("the add to cart button should be clickable")
    public void theAddToCartButtonShouldBeClickable() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isClickable = productDetailPage.isAddToCartButtonClickable();
        Assert.assertTrue("Add to cart button is not clickable", isClickable);
        System.out.println("Add to cart button is clickable");
    }

    @Then("the add to cart button should NOT be clickable")
    public void theAddToCartButtonShouldNotBeClickable() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isClickable = productDetailPage.isAddToCartButtonClickable();
        Assert.assertFalse("Add to cart button should not be clickable when quantity is 0", isClickable);
        System.out.println("Add to cart button is NOT clickable (as expected)");
    }

    @Then("the add to cart button should be enabled")
    public void theAddToCartButtonShouldBeEnabled() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isEnabled = productDetailPage.isAddToCartButtonEnabled();
        Assert.assertTrue("Add to cart button is not enabled", isEnabled);
        System.out.println("Add to cart button is enabled");
    }

    @Then("the add to cart button should be disabled")
    public void theAddToCartButtonShouldBeDisabled() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isEnabled = productDetailPage.isAddToCartButtonEnabled();
        Assert.assertFalse("Add to cart button should be disabled when quantity is 0", isEnabled);
        System.out.println("Add to cart button is disabled (as expected)");
    }

    @Then("the cart badge should show {int}")
    public void theCartBadgeShouldShow(int expectedCount) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int actualCount = productDetailPage.getCartBadgeCount();
        Assert.assertEquals("Cart badge count does not match", expectedCount, actualCount);
        System.out.println("Cart badge shows: " + actualCount);
    }

    @Then("the cart badge should be visible")
    public void theCartBadgeShouldBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isVisible = productDetailPage.isCartBadgeVisible();
        Assert.assertTrue("Cart badge should be visible after adding items", isVisible);
        System.out.println("Cart badge is visible");
    }

    @Then("the cart badge should NOT be visible")
    public void theCartBadgeShouldNotBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isVisible = productDetailPage.isCartBadgeVisible();
        Assert.assertFalse("Cart badge should not be visible when cart is empty", isVisible);
        System.out.println("Cart badge is NOT visible (cart is empty)");
    }

    @Then("the cart badge count should increase by the added quantity")
    public void theCartBadgeCountShouldIncreaseByTheAddedQuantity() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int currentCartCount = productDetailPage.getCartBadgeCount();
        int expectedCount = initialCartCount + quantityBeforeAddingToCart;

        System.out.println("Initial cart count: " + initialCartCount);
        System.out.println("Quantity added: " + quantityBeforeAddingToCart);
        System.out.println("Expected cart count: " + expectedCount);
        System.out.println("Actual cart count: " + currentCartCount);

        Assert.assertEquals("Cart badge count did not increase correctly", expectedCount, currentCartCount);
        System.out.println("Cart badge count increased correctly by " + quantityBeforeAddingToCart);
    }
}

