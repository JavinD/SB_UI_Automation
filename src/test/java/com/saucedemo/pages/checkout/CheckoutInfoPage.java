package com.saucedemo.pages.checkout;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
    private WebElement checkoutInfoTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement placeOrderButton;

    public boolean isCheckoutInfoPageDisplayed() {
        return isElementDisplayed(checkoutInfoTitle);
    }

    public String getCheckoutInfoTitle() {
        try {
            waitForElementToBeVisible(checkoutInfoTitle);
            return getText(checkoutInfoTitle);
        } catch (Exception e) {
            return "";
        }
    }

    public void clickPlaceOrderButton() {
        waitForElementToBeClickable(placeOrderButton);
        click(placeOrderButton);
        waitForSeconds(2);
    }

    public boolean isPlaceOrderButtonVisible() {
        return isElementDisplayed(placeOrderButton);
    }

    public boolean isPlaceOrderButtonClickable() {
        try {
            waitForElementToBeClickable(placeOrderButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
