package com.saucedemo.pages.productdetail;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityDisplay;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement plusButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private WebElement minusButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    public boolean isProductDetailPageDisplayed() {
        try {
            waitForSeconds(2);
            return isElementDisplayed(addToCartButton) && isElementDisplayed(quantityDisplay);
        } catch (Exception e) {
            return false;
        }
    }

    public int getCurrentQuantity() {
        try {
            waitForElementToBeVisible(quantityDisplay);
            String quantityText = getText(quantityDisplay);
            return Integer.parseInt(quantityText);
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickPlusButton() {
        waitForElementToBeClickable(plusButton);
        click(plusButton);
        waitForSeconds(1);
    }

    public void clickMinusButton() {
        waitForElementToBeClickable(minusButton);
        click(minusButton);
        waitForSeconds(1);
    }

    public void increaseQuantityBy(int times) {
        for (int i = 0; i < times; i++) {
            clickPlusButton();
        }
    }

    public void decreaseQuantityBy(int times) {
        for (int i = 0; i < times; i++) {
            clickMinusButton();
        }
    }

    public void setQuantityTo(int targetQuantity) {
        int currentQuantity = getCurrentQuantity();
        int difference = targetQuantity - currentQuantity;

        if (difference > 0) {
            increaseQuantityBy(difference);
        } else if (difference < 0) {
            decreaseQuantityBy(Math.abs(difference));
        }
    }

    public void clickAddToCart() {
        waitForElementToBeClickable(addToCartButton);
        click(addToCartButton);
        waitForSeconds(2);
    }

    public boolean isAddToCartButtonClickable() {
        try {
            waitForElementToBeClickable(addToCartButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAddToCartButtonEnabled() {
        try {
            return addToCartButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPlusButtonVisible() {
        return isElementDisplayed(plusButton);
    }

    public boolean isMinusButtonVisible() {
        return isElementDisplayed(minusButton);
    }

    public boolean isQuantityDisplayVisible() {
        return isElementDisplayed(quantityDisplay);
    }

    public boolean isAddToCartButtonVisible() {
        return isElementDisplayed(addToCartButton);
    }

    public boolean areAllProductDetailElementsVisible() {
        return isPlusButtonVisible() && isMinusButtonVisible() 
            && isQuantityDisplayVisible() && isAddToCartButtonVisible();
    }

    public String getProductTitle() {
        try {
            return getText(productTitle);
        } catch (Exception e) {
            return "";
        }
    }

    public String getProductPrice() {
        try {
            return getText(productPrice);
        } catch (Exception e) {
            return "";
        }
    }
}
