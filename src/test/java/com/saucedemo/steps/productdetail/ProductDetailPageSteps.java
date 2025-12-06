package com.saucedemo.steps.productdetail;

import com.saucedemo.pages.productdetail.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailPageSteps {

    private ProductDetailPage productDetailPage;
    private int initialCartCount = 0;
    private int quantityBeforeAddingToCart = 0;

    @Given("I am on the product detail page")
    public void iAmOnTheProductDetailPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        productDetailPage = new ProductDetailPage();
        boolean isDisplayed = productDetailPage.isProductDetailPageDisplayed();
        Assert.assertTrue("Product detail page is not displayed", isDisplayed);
    }

    @Then("all product detail elements should be visible")
    public void allProductDetailElementsShouldBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean allVisible = productDetailPage.areAllProductDetailElementsVisible();
        Assert.assertTrue("Not all product detail elements are visible", allVisible);
    }

    @Then("the default quantity should be {int}")
    public void theDefaultQuantityShouldBe(int expectedQuantity) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int actualQuantity = productDetailPage.getCurrentQuantity();
        Assert.assertEquals("Default quantity does not match", expectedQuantity, actualQuantity);
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

        initialCartCount = productDetailPage.getCartBadgeCount();
        quantityBeforeAddingToCart = productDetailPage.getCurrentQuantity();

        productDetailPage.clickAddToCart();
    }

    @Then("the add to cart button should be clickable")
    public void theAddToCartButtonShouldBeClickable() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isClickable = productDetailPage.isAddToCartButtonClickable();
        Assert.assertTrue("Add to cart button is not clickable", isClickable);
    }

    @Then("the add to cart button should NOT be clickable")
    public void theAddToCartButtonShouldNotBeClickable() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isClickable = productDetailPage.isAddToCartButtonClickable();
        Assert.assertFalse("Add to cart button should not be clickable when quantity is 0", isClickable);
    }

    @Then("the add to cart button should be enabled")
    public void theAddToCartButtonShouldBeEnabled() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isEnabled = productDetailPage.isAddToCartButtonEnabled();
        Assert.assertTrue("Add to cart button is not enabled", isEnabled);
    }

    @Then("the add to cart button should be disabled")
    public void theAddToCartButtonShouldBeDisabled() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isEnabled = productDetailPage.isAddToCartButtonEnabled();
        Assert.assertFalse("Add to cart button should be disabled when quantity is 0", isEnabled);
    }

    @Then("the cart badge should show {int}")
    public void theCartBadgeShouldShow(int expectedCount) {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int actualCount = productDetailPage.getCartBadgeCount();
        Assert.assertEquals("Cart badge count does not match", expectedCount, actualCount);
    }

    @Then("the cart badge should be visible")
    public void theCartBadgeShouldBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isVisible = productDetailPage.isCartBadgeVisible();
        Assert.assertTrue("Cart badge should be visible after adding items", isVisible);
    }

    @Then("the cart badge should NOT be visible")
    public void theCartBadgeShouldNotBeVisible() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        boolean isVisible = productDetailPage.isCartBadgeVisible();
        Assert.assertFalse("Cart badge should not be visible when cart is empty", isVisible);
    }

    @Then("the cart badge count should increase by the added quantity")
    public void theCartBadgeCountShouldIncreaseByTheAddedQuantity() {
        if (productDetailPage == null) {
            productDetailPage = new ProductDetailPage();
        }

        int currentCartCount = productDetailPage.getCartBadgeCount();
        int expectedCount = initialCartCount + quantityBeforeAddingToCart;

        Assert.assertEquals("Cart badge count did not increase correctly", expectedCount, currentCartCount);
    }
}
