package com.saucedemo.pages.productdetail;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Product Detail Page - Displays detailed information about a selected product
 * Allows user to adjust quantity and add product to cart
 * Extends HeaderComponent to inherit header functionality
 */
public class ProductDetailPage extends HeaderComponent {

    // Quantity display
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityDisplay;

    // Plus button (increase quantity)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement plusButton;

    // Minus button (decrease quantity)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private WebElement minusButton;

    // Add to cart button
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    // Product title (optional - for verification)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productTitle;

    // Product price (optional - for verification)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    public boolean isProductDetailPageDisplayed() {
        try {
            waitForSeconds(2);
            boolean hasAddToCartButton = isElementDisplayed(addToCartButton);
            boolean hasQuantityDisplay = isElementDisplayed(quantityDisplay);
            return hasAddToCartButton && hasQuantityDisplay;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get current quantity displayed
     * @return quantity as integer
     */
    public int getCurrentQuantity() {
        try {
            waitForElementToBeVisible(quantityDisplay);
            String quantityText = getText(quantityDisplay);
            return Integer.parseInt(quantityText);
        } catch (Exception e) {
            System.out.println("Could not read quantity: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Click plus button to increase quantity
     */
    public void clickPlusButton() {
        waitForElementToBeClickable(plusButton);
        click(plusButton);
        System.out.println("Clicked plus button to increase quantity");
        waitForSeconds(1); // Wait for UI update
    }

    /**
     * Click minus button to decrease quantity
     */
    public void clickMinusButton() {
        waitForElementToBeClickable(minusButton);
        click(minusButton);
        System.out.println("Clicked minus button to decrease quantity");
        waitForSeconds(1); // Wait for UI update
    }

    /**
     * Increase quantity by specified amount
     * @param times number of times to click plus button
     */
    public void increaseQuantityBy(int times) {
        for (int i = 0; i < times; i++) {
            clickPlusButton();
        }
        System.out.println("Increased quantity by " + times);
    }

    /**
     * Decrease quantity by specified amount
     * @param times number of times to click minus button
     */
    public void decreaseQuantityBy(int times) {
        for (int i = 0; i < times; i++) {
            clickMinusButton();
        }
        System.out.println("Decreased quantity by " + times);
    }

    /**
     * Set quantity to specific value
     * Note: This assumes current quantity and calculates difference
     * @param targetQuantity desired quantity
     */
    public void setQuantityTo(int targetQuantity) {
        int currentQuantity = getCurrentQuantity();
        int difference = targetQuantity - currentQuantity;

        if (difference > 0) {
            increaseQuantityBy(difference);
        } else if (difference < 0) {
            decreaseQuantityBy(Math.abs(difference));
        }

        System.out.println("Set quantity to " + targetQuantity);
    }

    /**
     * Click add to cart button
     */
    public void clickAddToCart() {
        waitForElementToBeClickable(addToCartButton);
        click(addToCartButton);
        System.out.println("Clicked add to cart button");
        waitForSeconds(2); // Wait for cart to update
    }

    /**
     * Check if add to cart button is clickable
     * @return true if button is clickable
     */
    public boolean isAddToCartButtonClickable() {
        try {
            waitForElementToBeClickable(addToCartButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if add to cart button is enabled
     * Note: When quantity is 0, button might be disabled
     * @return true if button is enabled
     */
    public boolean isAddToCartButtonEnabled() {
        try {
            return addToCartButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if plus button is visible
     * @return true if plus button is displayed
     */
    public boolean isPlusButtonVisible() {
        return isElementDisplayed(plusButton);
    }

    /**
     * Check if minus button is visible
     * @return true if minus button is displayed
     */
    public boolean isMinusButtonVisible() {
        return isElementDisplayed(minusButton);
    }

    /**
     * Check if quantity display is visible
     * @return true if quantity display is visible
     */
    public boolean isQuantityDisplayVisible() {
        return isElementDisplayed(quantityDisplay);
    }

    /**
     * Check if add to cart button is visible
     * @return true if add to cart button is visible
     */
    public boolean isAddToCartButtonVisible() {
        return isElementDisplayed(addToCartButton);
    }

    /**
     * Verify all product detail elements are visible
     * @return true if all main elements are visible
     */
    public boolean areAllProductDetailElementsVisible() {
        boolean plusVisible = isPlusButtonVisible();
        boolean minusVisible = isMinusButtonVisible();
        boolean quantityVisible = isQuantityDisplayVisible();
        boolean addToCartVisible = isAddToCartButtonVisible();

        System.out.println("Plus button visible: " + plusVisible);
        System.out.println("Minus button visible: " + minusVisible);
        System.out.println("Quantity display visible: " + quantityVisible);
        System.out.println("Add to cart button visible: " + addToCartVisible);

        return plusVisible && minusVisible && quantityVisible && addToCartVisible;
    }

    /**
     * Get product title text
     * @return product title
     */
    public String getProductTitle() {
        try {
            return getText(productTitle);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Get product price text
     * @return product price
     */
    public String getProductPrice() {
        try {
            return getText(productPrice);
        } catch (Exception e) {
            return "";
        }
    }
}

