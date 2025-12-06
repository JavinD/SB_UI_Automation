package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement checkoutCompleteTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/thankYouTV")
    private WebElement thankYouMessage;

    public boolean isCheckoutCompletePageDisplayed() {
        return isElementDisplayed(checkoutCompleteTitle) || isElementDisplayed(thankYouMessage);
    }

    public String getCheckoutCompleteTitle() {
        try {
            if (isElementDisplayed(checkoutCompleteTitle)) {
                waitForElementToBeVisible(checkoutCompleteTitle);
                return getText(checkoutCompleteTitle);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public String getThankYouMessage() {
        try {
            if (isElementDisplayed(thankYouMessage)) {
                waitForElementToBeVisible(thankYouMessage);
                return getText(thankYouMessage);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isOrderConfirmationVisible() {
        return isCheckoutCompletePageDisplayed();
    }
}
