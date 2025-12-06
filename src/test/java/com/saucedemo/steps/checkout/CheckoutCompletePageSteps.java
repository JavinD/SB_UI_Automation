package com.saucedemo.steps.checkout;

import com.saucedemo.pages.checkout.CheckoutCompletePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutCompletePageSteps {

    private CheckoutCompletePage checkoutCompletePage;

    @Then("I should be on the checkout complete page")
    public void iShouldBeOnTheCheckoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDisplayed = checkoutCompletePage.isCheckoutCompletePageDisplayed();
        Assert.assertTrue("Checkout complete page is not displayed after placing order", isDisplayed);
    }

    @Then("the checkout complete page should be displayed")
    public void theCheckoutCompletePageShouldBeDisplayed() {
        iShouldBeOnTheCheckoutCompletePage();
    }

    @Then("the order confirmation should be visible")
    public void theOrderConfirmationShouldBeVisible() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }

        boolean isVisible = checkoutCompletePage.isOrderConfirmationVisible();
        Assert.assertTrue("Order confirmation is not visible", isVisible);
    }
}
