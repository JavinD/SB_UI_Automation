package com.saucedemo.steps.checkout;

import com.saucedemo.pages.checkout.CheckoutInfoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class CheckoutInfoPageSteps {

    private CheckoutInfoPage checkoutInfoPage;

    @Then("I should be on the checkout info page")
    public void iShouldBeOnTheCheckoutInfoPage() {
        if (checkoutInfoPage == null) {
            checkoutInfoPage = new CheckoutInfoPage();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDisplayed = checkoutInfoPage.isCheckoutInfoPageDisplayed();
        Assert.assertTrue("Checkout info page is not displayed after payment info", isDisplayed);
    }

    @Then("the checkout info page should be displayed")
    public void theCheckoutInfoPageShouldBeDisplayed() {
        iShouldBeOnTheCheckoutInfoPage();
    }

    @When("I click the place order button")
    public void iClickThePlaceOrderButton() {
        if (checkoutInfoPage == null) {
            checkoutInfoPage = new CheckoutInfoPage();
        }

        checkoutInfoPage.clickPlaceOrderButton();
    }

    @Then("the place order button should be visible")
    public void thePlaceOrderButtonShouldBeVisible() {
        if (checkoutInfoPage == null) {
            checkoutInfoPage = new CheckoutInfoPage();
        }

        boolean isVisible = checkoutInfoPage.isPlaceOrderButtonVisible();
        Assert.assertTrue("Place order button is not visible", isVisible);
    }

    @Then("the place order button should be clickable")
    public void thePlaceOrderButtonShouldBeClickable() {
        if (checkoutInfoPage == null) {
            checkoutInfoPage = new CheckoutInfoPage();
        }

        boolean isClickable = checkoutInfoPage.isPlaceOrderButtonClickable();
        Assert.assertTrue("Place order button is not clickable", isClickable);
    }
}
