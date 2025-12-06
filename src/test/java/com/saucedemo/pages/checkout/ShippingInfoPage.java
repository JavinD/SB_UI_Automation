package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ShippingInfoPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private WebElement shippingInfoTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private WebElement fullNameInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    private WebElement addressLine1Input;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address2ET")
    private WebElement addressLine2Input;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    private WebElement cityInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/stateET")
    private WebElement stateInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    private WebElement zipCodeInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    private WebElement countryInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement paymentButton;

    public boolean isShippingInfoPageDisplayed() {
        return isElementDisplayed(shippingInfoTitle);
    }

    public boolean isShippingInfoTitleVisible() {
        return isElementDisplayed(shippingInfoTitle);
    }

    public String getShippingInfoTitle() {
        try {
            waitForElementToBeVisible(shippingInfoTitle);
            return getText(shippingInfoTitle);
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isFullNameInputVisible() {
        return isElementDisplayed(fullNameInput);
    }

    public boolean isAddressLine1InputVisible() {
        return isElementDisplayed(addressLine1Input);
    }

    public boolean isCityInputVisible() {
        return isElementDisplayed(cityInput);
    }

    public boolean isStateInputVisible() {
        return isElementDisplayed(stateInput);
    }

    public boolean isZipCodeInputVisible() {
        return isElementDisplayed(zipCodeInput);
    }

    public boolean isCountryInputVisible() {
        return isElementDisplayed(countryInput);
    }

    public void enterFullName(String fullName) {
        waitForElementToBeVisible(fullNameInput);
        sendKeys(fullNameInput, fullName);
    }

    public void enterAddressLine1(String address) {
        waitForElementToBeVisible(addressLine1Input);
        sendKeys(addressLine1Input, address);
    }

    public void enterAddressLine2(String address) {
        waitForElementToBeVisible(addressLine2Input);
        sendKeys(addressLine2Input, address);
    }

    public void enterCity(String city) {
        waitForElementToBeVisible(cityInput);
        sendKeys(cityInput, city);
    }

    public void enterState(String state) {
        waitForElementToBeVisible(stateInput);
        sendKeys(stateInput, state);
    }

    public void enterZipCode(String zipCode) {
        waitForElementToBeVisible(zipCodeInput);
        sendKeys(zipCodeInput, zipCode);
    }

    public void enterCountry(String country) {
        waitForElementToBeVisible(countryInput);
        sendKeys(countryInput, country);
    }

    public void clickPaymentButton() {
        waitForElementToBeClickable(paymentButton);
        click(paymentButton);
        waitForSeconds(2);
    }

    public boolean isPaymentButtonVisible() {
        return isElementDisplayed(paymentButton);
    }

    public boolean isPaymentButtonClickable() {
        try {
            waitForElementToBeClickable(paymentButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void fillShippingInfo(String fullName, String address, String city, String zipCode, String country) {
        enterFullName(fullName);
        enterAddressLine1(address);
        enterCity(city);
        enterZipCode(zipCode);
        enterCountry(country);
    }

    public boolean areAllShippingInfoFormElementsVisible() {
        return isShippingInfoTitleVisible() && isFullNameInputVisible() && isAddressLine1InputVisible() 
            && isCityInputVisible() && isStateInputVisible() && isZipCodeInputVisible() && isCountryInputVisible();
    }
}
