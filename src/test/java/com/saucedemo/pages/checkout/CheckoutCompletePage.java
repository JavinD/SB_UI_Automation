package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Checkout Complete Page - Displays order completion confirmation
 * Accessible after placing order from checkout info page
 * Extends HeaderComponent to inherit header functionality
 */
public class CheckoutCompletePage extends HeaderComponent {

    // Checkout complete title or confirmation message
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement checkoutCompleteTitle;

    // Alternative element - success message or icon
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/thankYouTV")
    private WebElement thankYouMessage;

    /**
     * Check if checkout complete page is displayed
     * @return true if checkout complete page is visible
     */
    public boolean isCheckoutCompletePageDisplayed() {
        // Check for either complete title or thank you message
        return isElementDisplayed(checkoutCompleteTitle) || isElementDisplayed(thankYouMessage);
    }

    /**
     * Get checkout complete title text
     * @return checkout complete title text
     */
    public String getCheckoutCompleteTitle() {
        try {
            if (isElementDisplayed(checkoutCompleteTitle)) {
                waitForElementToBeVisible(checkoutCompleteTitle);
                return getText(checkoutCompleteTitle);
            }
            return "";
        } catch (Exception e) {
            System.out.println("Could not get checkout complete title: " + e.getMessage());
            return "";
        }
    }

    /**
     * Get thank you message text
     * @return thank you message text
     */
    public String getThankYouMessage() {
        try {
            if (isElementDisplayed(thankYouMessage)) {
                waitForElementToBeVisible(thankYouMessage);
                return getText(thankYouMessage);
            }
            return "";
        } catch (Exception e) {
            System.out.println("Could not get thank you message: " + e.getMessage());
            return "";
        }
    }

    /**
     * Check if order confirmation is visible
     * @return true if any confirmation element is visible
     */
    public boolean isOrderConfirmationVisible() {
        return isCheckoutCompletePageDisplayed();
    }
}

