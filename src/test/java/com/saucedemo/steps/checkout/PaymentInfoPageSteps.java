package com.saucedemo.steps.checkout;

import com.saucedemo.pages.checkout.PaymentInfoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentInfoPageSteps {

    private PaymentInfoPage paymentInfoPage;

    @Given("I am on the payment info page")
    public void iAmOnThePaymentInfoPage() {
        paymentInfoPage = new PaymentInfoPage();
        boolean isDisplayed = paymentInfoPage.isPaymentInfoPageDisplayed();
        Assert.assertTrue("Payment info page is not displayed", isDisplayed);
    }

    @Then("I should be on the payment info page")
    public void iShouldBeOnThePaymentInfoPage() {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isDisplayed = paymentInfoPage.isPaymentInfoPageDisplayed();
        Assert.assertTrue("Payment info page is not displayed after shipping info", isDisplayed);
    }

    @When("I enter cardholder name {string}")
    public void iEnterCardholderName(String name) {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.enterCardholderName(name);
    }

    @When("I enter card number {string}")
    public void iEnterCardNumber(String cardNumber) {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.enterCardNumber(cardNumber);
    }

    @When("I enter expiration date {string}")
    public void iEnterExpirationDate(String expirationDate) {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.enterExpirationDate(expirationDate);
    }

    @When("I enter security code {string}")
    public void iEnterSecurityCode(String securityCode) {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.enterSecurityCode(securityCode);
    }

    @When("I click the review order button")
    public void iClickTheReviewOrderButton() {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.clickReviewOrderButton();
    }

    @When("I fill all payment information with {string}, {string}, {string}, {string}")
    public void iFillAllPaymentInformationWith(String cardholderName, String cardNumber, String expirationDate, String securityCode) {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        paymentInfoPage.fillPaymentInfo(cardholderName, cardNumber, expirationDate, securityCode);
    }

    @Then("all payment info form elements should be visible")
    public void allPaymentInfoFormElementsShouldBeVisible() {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        boolean allVisible = paymentInfoPage.areAllPaymentInfoFormElementsVisible();
        Assert.assertTrue("Not all payment info form elements are visible", allVisible);
    }

    @Then("the review order button should be visible")
    public void theReviewOrderButtonShouldBeVisible() {
        if (paymentInfoPage == null) {
            paymentInfoPage = new PaymentInfoPage();
        }

        boolean isVisible = paymentInfoPage.isReviewOrderButtonVisible();
        Assert.assertTrue("Review order button is not visible", isVisible);
    }
}
