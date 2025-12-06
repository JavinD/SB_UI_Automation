package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PaymentInfoPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/enterPaymentTitleTV")
    private WebElement paymentTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement cardholderNameInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    private WebElement cardNumberInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    private WebElement expirationDateInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    private WebElement securityCodeInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement reviewOrderButton;

    public boolean isPaymentInfoPageDisplayed() {
        return isElementDisplayed(paymentTitle);
    }

    public String getPaymentTitle() {
        try {
            waitForElementToBeVisible(paymentTitle);
            return getText(paymentTitle);
        } catch (Exception e) {
            return "";
        }
    }

    public void enterCardholderName(String name) {
        waitForElementToBeVisible(cardholderNameInput);
        sendKeys(cardholderNameInput, name);
    }

    public void enterCardNumber(String cardNumber) {
        waitForElementToBeVisible(cardNumberInput);
        sendKeys(cardNumberInput, cardNumber);
    }

    public void enterExpirationDate(String expirationDate) {
        waitForElementToBeVisible(expirationDateInput);
        sendKeys(expirationDateInput, expirationDate);
    }

    public void enterSecurityCode(String securityCode) {
        waitForElementToBeVisible(securityCodeInput);
        sendKeys(securityCodeInput, securityCode);
    }

    public void clickReviewOrderButton() {
        waitForElementToBeClickable(reviewOrderButton);
        click(reviewOrderButton);
        waitForSeconds(2);
    }

    public void fillPaymentInfo(String cardholderName, String cardNumber, String expirationDate, String securityCode) {
        enterCardholderName(cardholderName);
        enterCardNumber(cardNumber);
        enterExpirationDate(expirationDate);
        enterSecurityCode(securityCode);
    }

    public boolean isCardholderNameInputVisible() {
        return isElementDisplayed(cardholderNameInput);
    }

    public boolean isCardNumberInputVisible() {
        return isElementDisplayed(cardNumberInput);
    }

    public boolean isExpirationDateInputVisible() {
        return isElementDisplayed(expirationDateInput);
    }

    public boolean isSecurityCodeInputVisible() {
        return isElementDisplayed(securityCodeInput);
    }

    public boolean isReviewOrderButtonVisible() {
        return isElementDisplayed(reviewOrderButton);
    }

    public boolean areAllPaymentInfoFormElementsVisible() {
        return isCardholderNameInputVisible() && isCardNumberInputVisible() 
            && isExpirationDateInputVisible() && isSecurityCodeInputVisible() && isReviewOrderButtonVisible();
    }
}
