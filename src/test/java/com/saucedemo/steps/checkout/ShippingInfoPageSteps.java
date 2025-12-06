package com.saucedemo.steps.checkout;

import com.saucedemo.pages.checkout.ShippingInfoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShippingInfoPageSteps {

    private ShippingInfoPage shippingInfoPage;

    @Given("I am on the shipping info page")
    public void iAmOnTheShippingInfoPage() {
        shippingInfoPage = new ShippingInfoPage();
        boolean isDisplayed = shippingInfoPage.isShippingInfoPageDisplayed();
        Assert.assertTrue("Shipping info page is not displayed", isDisplayed);
    }

    @Then("I should be on the shipping info page")
    public void iShouldBeOnTheShippingInfoPage() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDisplayed = shippingInfoPage.isShippingInfoPageDisplayed();
        Assert.assertTrue("Shipping info page is not displayed after login", isDisplayed);
    }

    @Then("the shipping info page should be displayed")
    public void theShippingInfoPageShouldBeDisplayed() {
        iShouldBeOnTheShippingInfoPage();
    }

    @Then("the shipping info title should be visible")
    public void theShippingInfoTitleShouldBeVisible() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        boolean isVisible = shippingInfoPage.isShippingInfoTitleVisible();
        Assert.assertTrue("Shipping info title is not visible", isVisible);
    }

    @Then("I should see the shipping info title")
    public void iShouldSeeTheShippingInfoTitle() {
        theShippingInfoTitleShouldBeVisible();
    }

    @Then("all shipping info form elements should be visible")
    public void allShippingInfoFormElementsShouldBeVisible() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        boolean allVisible = shippingInfoPage.areAllShippingInfoFormElementsVisible();
        Assert.assertTrue("Not all shipping info form elements are visible", allVisible);
    }

    @When("I enter full name {string}")
    public void iEnterFullName(String fullName) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterFullName(fullName);
    }

    @When("I enter address line 1 {string}")
    public void iEnterAddressLine1(String address) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterAddressLine1(address);
    }

    @When("I enter city {string}")
    public void iEnterCity(String city) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterCity(city);
    }

    @When("I enter state {string}")
    public void iEnterState(String state) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterState(state);
    }

    @When("I enter zip code {string}")
    public void iEnterZipCode(String zipCode) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterZipCode(zipCode);
    }

    @When("I enter country {string}")
    public void iEnterCountry(String country) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.enterCountry(country);
    }

    @When("I click the payment button")
    public void iClickThePaymentButton() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.clickPaymentButton();
    }

    @When("I fill all shipping information with {string}, {string}, {string}, {string}, {string}")
    public void iFillAllShippingInformationWith(String fullName, String address, String city, String zipCode, String country) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        shippingInfoPage.fillShippingInfo(fullName, address, city, zipCode, country);
    }

    @Then("the payment button should be visible")
    public void thePaymentButtonShouldBeVisible() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        boolean isVisible = shippingInfoPage.isPaymentButtonVisible();
        Assert.assertTrue("Payment button is not visible", isVisible);
    }

    @Then("the payment button should be clickable")
    public void thePaymentButtonShouldBeClickable() {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        boolean isClickable = shippingInfoPage.isPaymentButtonClickable();
        Assert.assertTrue("Payment button is not clickable", isClickable);
    }

    @Then("the shipping info title should display {string}")
    public void theShippingInfoTitleShouldDisplay(String expectedTitle) {
        if (shippingInfoPage == null) {
            shippingInfoPage = new ShippingInfoPage();
        }

        String actualTitle = shippingInfoPage.getShippingInfoTitle();
        Assert.assertEquals("Shipping info title does not match", expectedTitle, actualTitle);
    }
}
