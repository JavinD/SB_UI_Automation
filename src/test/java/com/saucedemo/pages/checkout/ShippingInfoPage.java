package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Shipping Info Page - Displays shipping information form for checkout
 * Accessible after successful login from cart page
 * Extends HeaderComponent to inherit header functionality
 */
public class ShippingInfoPage extends HeaderComponent {

    // Checkout title - main indicator that we're on shipping info page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private WebElement shippingInfoTitle;

    // Shipping form elements
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

    // Payment button - proceeds to payment page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement paymentButton;

    /**
     * Check if shipping info page is displayed
     * Primary verification via checkoutTitleTV element
     * @return true if shipping info page is visible
     */
    public boolean isShippingInfoPageDisplayed() {
        return isElementDisplayed(shippingInfoTitle);
    }

    /**
     * Check if shipping info title is visible
     * @return true if shipping info title is displayed
     */
    public boolean isShippingInfoTitleVisible() {
        return isElementDisplayed(shippingInfoTitle);
    }

    /**
     * Get shipping info title text
     * @return shipping info title text
     */
    public String getShippingInfoTitle() {
        try {
            waitForElementToBeVisible(shippingInfoTitle);
            return getText(shippingInfoTitle);
        } catch (Exception e) {
            System.out.println("Could not get shipping info title: " + e.getMessage());
            return "";
        }
    }

    /**
     * Check if full name input is visible
     * @return true if full name field is displayed
     */
    public boolean isFullNameInputVisible() {
        return isElementDisplayed(fullNameInput);
    }

    /**
     * Check if address line 1 input is visible
     * @return true if address field is displayed
     */
    public boolean isAddressLine1InputVisible() {
        return isElementDisplayed(addressLine1Input);
    }

    /**
     * Check if city input is visible
     * @return true if city field is displayed
     */
    public boolean isCityInputVisible() {
        return isElementDisplayed(cityInput);
    }

    /**
     * Check if state input is visible
     * @return true if state field is displayed
     */
    public boolean isStateInputVisible() {
        return isElementDisplayed(stateInput);
    }

    /**
     * Check if zip code input is visible
     * @return true if zip code field is displayed
     */
    public boolean isZipCodeInputVisible() {
        return isElementDisplayed(zipCodeInput);
    }

    /**
     * Check if country input is visible
     * @return true if country field is displayed
     */
    public boolean isCountryInputVisible() {
        return isElementDisplayed(countryInput);
    }

    /**
     * Enter full name
     * @param fullName full name to enter
     */
    public void enterFullName(String fullName) {
        waitForElementToBeVisible(fullNameInput);
        sendKeys(fullNameInput, fullName);
        System.out.println("Entered full name: " + fullName);
    }

    /**
     * Enter address line 1
     * @param address address to enter
     */
    public void enterAddressLine1(String address) {
        waitForElementToBeVisible(addressLine1Input);
        sendKeys(addressLine1Input, address);
        System.out.println("Entered address line 1: " + address);
    }

    /**
     * Enter address line 2
     * @param address address to enter
     */
    public void enterAddressLine2(String address) {
        waitForElementToBeVisible(addressLine2Input);
        sendKeys(addressLine2Input, address);
        System.out.println("Entered address line 2: " + address);
    }

    /**
     * Enter city
     * @param city city to enter
     */
    public void enterCity(String city) {
        waitForElementToBeVisible(cityInput);
        sendKeys(cityInput, city);
        System.out.println("Entered city: " + city);
    }

    /**
     * Enter state
     * @param state state to enter
     */
    public void enterState(String state) {
        waitForElementToBeVisible(stateInput);
        sendKeys(stateInput, state);
        System.out.println("Entered state: " + state);
    }

    /**
     * Enter zip code
     * @param zipCode zip code to enter
     */
    public void enterZipCode(String zipCode) {
        waitForElementToBeVisible(zipCodeInput);
        sendKeys(zipCodeInput, zipCode);
        System.out.println("Entered zip code: " + zipCode);
    }

    /**
     * Enter country
     * @param country country to enter
     */
    public void enterCountry(String country) {
        waitForElementToBeVisible(countryInput);
        sendKeys(countryInput, country);
        System.out.println("Entered country: " + country);
    }

    /**
     * Click payment button to proceed to payment page
     */
    public void clickPaymentButton() {
        waitForElementToBeClickable(paymentButton);
        click(paymentButton);
        System.out.println("Clicked payment button");
        waitForSeconds(2); // Wait for navigation to payment page
    }

    /**
     * Check if payment button is visible
     * @return true if payment button is displayed
     */
    public boolean isPaymentButtonVisible() {
        return isElementDisplayed(paymentButton);
    }

    /**
     * Check if payment button is clickable
     * @return true if payment button is clickable
     */
    public boolean isPaymentButtonClickable() {
        try {
            waitForElementToBeClickable(paymentButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Fill all shipping info fields
     * @param fullName full name
     * @param address address line 1
     * @param city city
     * @param zipCode zip code
     * @param country country
     */
    public void fillShippingInfo(String fullName, String address, String city, String zipCode, String country) {
        enterFullName(fullName);
        enterAddressLine1(address);
        enterCity(city);
        enterZipCode(zipCode);
        enterCountry(country);
        System.out.println("Filled all shipping information");
    }

    /**
     * Verify all shipping info form elements are visible
     * @return true if all form elements are visible
     */
    public boolean areAllShippingInfoFormElementsVisible() {
        boolean titleVisible = isShippingInfoTitleVisible();
        boolean fullNameVisible = isFullNameInputVisible();
        boolean addressVisible = isAddressLine1InputVisible();
        boolean cityVisible = isCityInputVisible();
        boolean stateVisible = isStateInputVisible();
        boolean zipVisible = isZipCodeInputVisible();
        boolean countryVisible = isCountryInputVisible();

        System.out.println("Shipping info title visible: " + titleVisible);
        System.out.println("Full name visible: " + fullNameVisible);
        System.out.println("Address visible: " + addressVisible);
        System.out.println("City visible: " + cityVisible);
        System.out.println("State visible: " + stateVisible);
        System.out.println("Zip code visible: " + zipVisible);
        System.out.println("Country visible: " + countryVisible);

        return titleVisible && fullNameVisible && addressVisible && cityVisible 
               && stateVisible && zipVisible && countryVisible;
    }
}

