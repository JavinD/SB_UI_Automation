package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Checkout Info Page - Displays order review and checkout information
 * Accessible after filling payment information
 * Extends HeaderComponent to inherit header functionality
 */
public class CheckoutInfoPage extends HeaderComponent {

    // Checkout info title or any element to verify we're on checkout info page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private WebElement checkoutInfoTitle;

    // Place order/payment button - proceeds to checkout complete page
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement placeOrderButton;

    /**
     * Check if checkout info page is displayed
     * @return true if checkout info page is visible
     */
    public boolean isCheckoutInfoPageDisplayed() {
        return isElementDisplayed(checkoutInfoTitle);
    }

    /**
     * Get checkout info title text
     * @return checkout info title text
     */
    public String getCheckoutInfoTitle() {
        try {
            waitForElementToBeVisible(checkoutInfoTitle);
            return getText(checkoutInfoTitle);
        } catch (Exception e) {
            System.out.println("Could not get checkout info title: " + e.getMessage());
            return "";
        }
    }

    /**
     * Click place order button to complete the purchase
     */
    public void clickPlaceOrderButton() {
        waitForElementToBeClickable(placeOrderButton);
        click(placeOrderButton);
        System.out.println("Clicked place order button");
        waitForSeconds(2); // Wait for order completion
    }

    /**
     * Check if place order button is visible
     * @return true if place order button is displayed
     */
    public boolean isPlaceOrderButtonVisible() {
        return isElementDisplayed(placeOrderButton);
    }

    /**
     * Check if place order button is clickable
     * @return true if place order button is clickable
     */
    public boolean isPlaceOrderButtonClickable() {
        try {
            waitForElementToBeClickable(placeOrderButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

