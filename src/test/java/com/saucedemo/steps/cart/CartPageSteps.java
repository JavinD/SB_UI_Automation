package com.saucedemo.steps.cart;

import com.saucedemo.pages.cart.CartPage;
import com.saucedemo.pages.productdetail.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Step definitions for Cart Page functionality
 * Tests empty cart, cart items, quantity changes, and checkout
 */
public class CartPageSteps {

    private CartPage cartPage;
    private ProductDetailPage productDetailPage;
    private int initialItemCount = 0;
    private int initialQuantity = 0;

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        cartPage = new CartPage();
        boolean isDisplayed = cartPage.isCartPageDisplayed();
        Assert.assertTrue("Cart page is not displayed", isDisplayed);
        System.out.println("User is on cart page");
    }

    @When("I navigate to cart page")
    public void iNavigateToCartPage() {
        // Use HeaderComponent method to click cart
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        cartPage.clickCart();
        System.out.println("Navigated to cart page");
        
        try {
            Thread.sleep(2000); // Wait for cart page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean isEmpty = cartPage.isCartEmpty();
        Assert.assertTrue("Cart should be empty but it's not", isEmpty);
        System.out.println("Cart is empty");
    }

    @Then("I should see the empty cart message")
    public void iShouldSeeTheEmptyCartMessage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean isEmpty = cartPage.isCartEmpty();
        String message = cartPage.getEmptyCartMessage();
        
        Assert.assertTrue("Empty cart message is not displayed", isEmpty);
        Assert.assertFalse("Empty cart message text is empty", message.isEmpty());
        System.out.println("Empty cart message: " + message);
    }

    @Then("the cart should have items")
    public void theCartShouldHaveItems() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean hasItems = cartPage.hasItemsInCart();
        Assert.assertTrue("Cart should have items but it's empty", hasItems);
        System.out.println("Cart has items");
    }

    @Then("the cart should NOT be empty")
    public void theCartShouldNotBeEmpty() {
        theCartShouldHaveItems();
    }

    @Then("I should see {int} item in the cart")
    public void iShouldSeeItemInTheCart(int expectedCount) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int actualCount = cartPage.getCartItemCount();
        Assert.assertEquals("Cart item count does not match", expectedCount, actualCount);
        System.out.println("Cart has " + actualCount + " item(s)");
    }

    @Then("I should see at least {int} item in the cart")
    public void iShouldSeeAtLeastItemInTheCart(int minCount) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int actualCount = cartPage.getCartItemCount();
        Assert.assertTrue("Expected at least " + minCount + " items, but found " + actualCount,
                         actualCount >= minCount);
        System.out.println("Cart has " + actualCount + " item(s)");
    }

    @When("I click the plus button for the first item in cart")
    public void iClickThePlusButtonForTheFirstItemInCart() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        initialQuantity = cartPage.getItemQuantity(0);
        cartPage.increaseFirstItemQuantity();
    }

    @When("I click the minus button for the first item in cart")
    public void iClickTheMinusButtonForTheFirstItemInCart() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        initialQuantity = cartPage.getItemQuantity(0);
        cartPage.decreaseFirstItemQuantity();
    }

    @When("I increase the first item quantity by {int}")
    public void iIncreaseTheFirstItemQuantityBy(int times) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        cartPage.increaseItemQuantityBy(0, times);
    }

    @When("I decrease the first item quantity by {int}")
    public void iDecreaseTheFirstItemQuantityBy(int times) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        cartPage.decreaseItemQuantityBy(0, times);
    }

    @Then("the quantity of the first item should be {int}")
    public void theQuantityOfTheFirstItemShouldBe(int expectedQuantity) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int actualQuantity = cartPage.getItemQuantity(0);
        Assert.assertEquals("Item quantity does not match", expectedQuantity, actualQuantity);
        System.out.println("First item quantity is: " + actualQuantity);
    }

    @Then("the cart item quantity should increase to {int}")
    public void theCartItemQuantityShouldIncreaseTo(int expectedQuantity) {
        theQuantityOfTheFirstItemShouldBe(expectedQuantity);
    }

    @Then("the cart item quantity should decrease to {int}")
    public void theCartItemQuantityShouldDecreaseTo(int expectedQuantity) {
        theQuantityOfTheFirstItemShouldBe(expectedQuantity);
    }

    @When("I click the remove button for the first item")
    public void iClickTheRemoveButtonForTheFirstItem() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        initialItemCount = cartPage.getCartItemCount();
        cartPage.removeFirstItem();
    }

    @When("I remove the first item from cart")
    public void iRemoveTheFirstItemFromCart() {
        iClickTheRemoveButtonForTheFirstItem();
    }

    @Then("the item should be removed from cart")
    public void theItemShouldBeRemovedFromCart() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int currentItemCount = cartPage.getCartItemCount();
        
        // Either cart is now empty or item count decreased
        boolean itemRemoved = (currentItemCount < initialItemCount) || cartPage.isCartEmpty();
        Assert.assertTrue("Item was not removed from cart", itemRemoved);
        System.out.println("Item successfully removed from cart");
    }

    @When("I decrease the quantity to {int}")
    public void iDecreaseTheQuantityTo(int targetQuantity) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int currentQuantity = cartPage.getItemQuantity(0);
        int difference = currentQuantity - targetQuantity;
        
        if (difference > 0) {
            cartPage.decreaseItemQuantityBy(0, difference);
        }
    }

    @Then("the first item should be removed from cart")
    public void theFirstItemShouldBeRemovedFromCart() {
        theItemShouldBeRemovedFromCart();
    }

    @Then("all cart item controls should be visible for the first item")
    public void allCartItemControlsShouldBeVisibleForTheFirstItem() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean allVisible = cartPage.areCartItemControlsVisible(0);
        Assert.assertTrue("Not all cart item controls are visible", allVisible);
        System.out.println("All cart item controls are visible");
    }

    @Then("the checkout button should be visible")
    public void theCheckoutButtonShouldBeVisible() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean isVisible = cartPage.isCheckoutButtonVisible();
        Assert.assertTrue("Checkout button is not visible", isVisible);
        System.out.println("Checkout button is visible");
    }

    @Then("the checkout button should NOT be visible")
    public void theCheckoutButtonShouldNotBeVisible() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean isVisible = cartPage.isCheckoutButtonVisible();
        Assert.assertFalse("Checkout button should not be visible when cart is empty", isVisible);
        System.out.println("Checkout button is NOT visible (cart is empty)");
    }

    @Then("the checkout button should be clickable")
    public void theCheckoutButtonShouldBeClickable() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        boolean isClickable = cartPage.isCheckoutButtonClickable();
        Assert.assertTrue("Checkout button is not clickable", isClickable);
        System.out.println("Checkout button is clickable");
    }

    @When("I click the checkout button")
    public void iClickTheCheckoutButton() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        cartPage.clickCheckoutButton();
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        iClickTheCheckoutButton();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        // This would be verified by checking login page elements
        // For now, just log that navigation should have happened
        System.out.println("Should be on login page now");
        
        try {
            Thread.sleep(2000); // Wait for login page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        cartPage.removeAllItems();
    }

    @Then("the total quantity in cart should be {int}")
    public void theTotalQuantityInCartShouldBe(int expectedTotal) {
        if (cartPage == null) {
            cartPage = new CartPage();
        }

        int actualTotal = cartPage.getTotalQuantity();
        Assert.assertEquals("Total cart quantity does not match", expectedTotal, actualTotal);
        System.out.println("Total quantity in cart: " + actualTotal);
    }
}

