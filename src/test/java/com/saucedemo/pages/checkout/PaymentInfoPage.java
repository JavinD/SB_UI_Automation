package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Payment Info Page - Displays payment information form
 * Accessible after filling shipping information
 * Extends HeaderComponent to inherit header functionality
 */
public class PaymentInfoPage extends HeaderComponent {

    // Payment title or any element to verify we're on payment page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/enterPaymentTitleTV")
    private WebElement paymentTitle;

    // Cardholder name input
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement cardholderNameInput;

    // Card number input
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    private WebElement cardNumberInput;

    // Expiration date input
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    private WebElement expirationDateInput;

    // Security code (CVV) input
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    private WebElement securityCodeInput;

    // Review order button - proceeds to checkout info/review page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement reviewOrderButton;

    /**
     * Check if payment info page is displayed
     * @return true if payment info page is visible
     */
    public boolean isPaymentInfoPageDisplayed() {
        return isElementDisplayed(paymentTitle);
    }

    /**
     * Get payment title text
     * @return payment title text
     */
    public String getPaymentTitle() {
        try {
            waitForElementToBeVisible(paymentTitle);
            return getText(paymentTitle);
        } catch (Exception e) {
            System.out.println("Could not get payment title: " + e.getMessage());
            return "";
        }
    }

    /**
     * Enter cardholder name
     * @param name cardholder name
     */
    public void enterCardholderName(String name) {
        waitForElementToBeVisible(cardholderNameInput);
        sendKeys(cardholderNameInput, name);
        System.out.println("Entered cardholder name: " + name);
    }

    /**
     * Enter card number
     * @param cardNumber card number
     */
    public void enterCardNumber(String cardNumber) {
        waitForElementToBeVisible(cardNumberInput);
        sendKeys(cardNumberInput, cardNumber);
        System.out.println("Entered card number: " + cardNumber);
    }

    /**
     * Enter expiration date
     * @param expirationDate expiration date (e.g., "1225" for 12/25)
     */
    public void enterExpirationDate(String expirationDate) {
        waitForElementToBeVisible(expirationDateInput);
        sendKeys(expirationDateInput, expirationDate);
        System.out.println("Entered expiration date: " + expirationDate);
    }

    /**
     * Enter security code (CVV)
     * @param securityCode security code
     */
    public void enterSecurityCode(String securityCode) {
        waitForElementToBeVisible(securityCodeInput);
        sendKeys(securityCodeInput, securityCode);
        System.out.println("Entered security code: " + securityCode);
    }

    /**
     * Click review order button to proceed to checkout info page
     */
    public void clickReviewOrderButton() {
        waitForElementToBeClickable(reviewOrderButton);
        click(reviewOrderButton);
        System.out.println("Clicked review order button");
        waitForSeconds(2); // Wait for navigation
    }

    /**
     * Fill all payment info fields
     * @param cardholderName cardholder name
     * @param cardNumber card number
     * @param expirationDate expiration date
     * @param securityCode security code (CVV)
     */
    public void fillPaymentInfo(String cardholderName, String cardNumber, String expirationDate, String securityCode) {
        enterCardholderName(cardholderName);
        enterCardNumber(cardNumber);
        enterExpirationDate(expirationDate);
        enterSecurityCode(securityCode);
        System.out.println("Filled all payment information");
    }

    /**
     * Check if cardholder name input is visible
     * @return true if visible
     */
    public boolean isCardholderNameInputVisible() {
        return isElementDisplayed(cardholderNameInput);
    }

    /**
     * Check if card number input is visible
     * @return true if visible
     */
    public boolean isCardNumberInputVisible() {
        return isElementDisplayed(cardNumberInput);
    }

    /**
     * Check if expiration date input is visible
     * @return true if visible
     */
    public boolean isExpirationDateInputVisible() {
        return isElementDisplayed(expirationDateInput);
    }

    /**
     * Check if security code input is visible
     * @return true if visible
     */
    public boolean isSecurityCodeInputVisible() {
        return isElementDisplayed(securityCodeInput);
    }

    /**
     * Check if review order button is visible
     * @return true if visible
     */
    public boolean isReviewOrderButtonVisible() {
        return isElementDisplayed(reviewOrderButton);
    }

    /**
     * Verify all payment info form elements are visible
     * @return true if all elements are visible
     */
    public boolean areAllPaymentInfoFormElementsVisible() {
        boolean nameVisible = isCardholderNameInputVisible();
        boolean cardVisible = isCardNumberInputVisible();
        boolean dateVisible = isExpirationDateInputVisible();
        boolean cvvVisible = isSecurityCodeInputVisible();
        boolean buttonVisible = isReviewOrderButtonVisible();

        System.out.println("Cardholder name visible: " + nameVisible);
        System.out.println("Card number visible: " + cardVisible);
        System.out.println("Expiration date visible: " + dateVisible);
        System.out.println("Security code visible: " + cvvVisible);
        System.out.println("Review order button visible: " + buttonVisible);

        return nameVisible && cardVisible && dateVisible && cvvVisible && buttonVisible;
    }
}

