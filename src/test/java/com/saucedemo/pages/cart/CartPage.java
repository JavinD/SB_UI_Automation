package com.saucedemo.pages.cart;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Cart Page - Displays items added to cart
 * Has two states: Empty (no items) and Filled (has items)
 * Extends HeaderComponent to inherit header functionality
 */
public class CartPage extends HeaderComponent {

    // Empty cart indicator
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private WebElement emptyCartTitle;

    // Product images in cart (indicates cart has items)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> productImages;

    // Product titles in cart
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<WebElement> productTitles;

    // Product prices in cart
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<WebElement> productPrices;

    // Quantity display for cart items
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private List<WebElement> quantityDisplays;

    // Plus buttons (increase quantity)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private List<WebElement> plusButtons;

    // Minus buttons (decrease quantity)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private List<WebElement> minusButtons;

    // Remove buttons (remove item immediately)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private List<WebElement> removeButtons;

    // Proceed to checkout button
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement checkoutButton;

    /**
     * Check if cart page is displayed
     * @return true if cart page is visible
     */
    public boolean isCartPageDisplayed() {
        return isHeaderDisplayed();
    }

    /**
     * Check if cart is empty
     * @return true if empty cart message is displayed
     */
    public boolean isCartEmpty() {
        return isElementDisplayed(emptyCartTitle);
    }

    /**
     * Check if cart has items
     * @return true if product images are visible (cart has items)
     */
    public boolean hasItemsInCart() {
        return productImages != null && !productImages.isEmpty() && isElementDisplayed(productImages.get(0));
    }

    /**
     * Get the empty cart message text
     * @return empty cart message
     */
    public String getEmptyCartMessage() {
        if (isCartEmpty()) {
            return getText(emptyCartTitle);
        }
        return "";
    }

    /**
     * Get number of items in cart
     * @return count of cart items
     */
    public int getCartItemCount() {
        if (hasItemsInCart()) {
            return productImages.size();
        }
        return 0;
    }

    /**
     * Get product title by index
     * @param index cart item index (0-based)
     * @return product title
     */
    public String getProductTitle(int index) {
        if (index < productTitles.size()) {
            return getText(productTitles.get(index));
        }
        return "";
    }

    /**
     * Get product price by index
     * @param index cart item index (0-based)
     * @return product price
     */
    public String getProductPrice(int index) {
        if (index < productPrices.size()) {
            return getText(productPrices.get(index));
        }
        return "";
    }

    /**
     * Get quantity of cart item by index
     * @param index cart item index (0-based)
     * @return quantity as integer
     */
    public int getItemQuantity(int index) {
        try {
            if (index < quantityDisplays.size()) {
                String quantityText = getText(quantityDisplays.get(index));
                return Integer.parseInt(quantityText);
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Could not read quantity for item " + index + ": " + e.getMessage());
            return 0;
        }
    }

    /**
     * Click plus button to increase quantity for specific item
     * @param index cart item index (0-based)
     */
    public void clickPlusButton(int index) {
        if (index < plusButtons.size()) {
            waitForElementToBeClickable(plusButtons.get(index));
            click(plusButtons.get(index));
            System.out.println("Clicked plus button for item at index " + index);
            waitForSeconds(1); // Wait for UI update
        } else {
            throw new IndexOutOfBoundsException("Plus button index " + index + " out of bounds");
        }
    }

    /**
     * Click minus button to decrease quantity for specific item
     * Note: If quantity is 1, clicking minus will remove the item from cart
     * @param index cart item index (0-based)
     */
    public void clickMinusButton(int index) {
        if (index < minusButtons.size()) {
            waitForElementToBeClickable(minusButtons.get(index));
            click(minusButtons.get(index));
            System.out.println("Clicked minus button for item at index " + index);
            waitForSeconds(1); // Wait for UI update
        } else {
            throw new IndexOutOfBoundsException("Minus button index " + index + " out of bounds");
        }
    }

    /**
     * Click remove button to immediately remove item from cart
     * @param index cart item index (0-based)
     */
    public void clickRemoveButton(int index) {
        if (index < removeButtons.size()) {
            waitForElementToBeClickable(removeButtons.get(index));
            click(removeButtons.get(index));
            System.out.println("Clicked remove button for item at index " + index);
            waitForSeconds(1); // Wait for item removal
        } else {
            throw new IndexOutOfBoundsException("Remove button index " + index + " out of bounds");
        }
    }

    /**
     * Increase quantity for first item in cart
     */
    public void increaseFirstItemQuantity() {
        clickPlusButton(0);
    }

    /**
     * Decrease quantity for first item in cart
     */
    public void decreaseFirstItemQuantity() {
        clickMinusButton(0);
    }

    /**
     * Remove first item from cart
     */
    public void removeFirstItem() {
        clickRemoveButton(0);
    }

    /**
     * Increase quantity for specific item by given amount
     * @param index cart item index
     * @param times number of times to increase
     */
    public void increaseItemQuantityBy(int index, int times) {
        for (int i = 0; i < times; i++) {
            clickPlusButton(index);
        }
        System.out.println("Increased item " + index + " quantity by " + times);
    }

    /**
     * Decrease quantity for specific item by given amount
     * @param index cart item index
     * @param times number of times to decrease
     */
    public void decreaseItemQuantityBy(int index, int times) {
        for (int i = 0; i < times; i++) {
            clickMinusButton(index);
        }
        System.out.println("Decreased item " + index + " quantity by " + times);
    }

    /**
     * Check if checkout button is visible
     * Only visible when cart has items
     * @return true if checkout button is displayed
     */
    public boolean isCheckoutButtonVisible() {
        return isElementDisplayed(checkoutButton);
    }

    /**
     * Check if checkout button is clickable
     * @return true if checkout button is clickable
     */
    public boolean isCheckoutButtonClickable() {
        try {
            waitForElementToBeClickable(checkoutButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click proceed to checkout button
     * Will redirect to login page
     */
    public void clickCheckoutButton() {
        waitForElementToBeClickable(checkoutButton);
        click(checkoutButton);
        System.out.println("Clicked checkout button - redirecting to login page");
        waitForSeconds(2); // Wait for navigation
    }

    /**
     * Remove all items from cart by clicking remove button for each
     */
    public void removeAllItems() {
        int itemCount = getCartItemCount();
        for (int i = itemCount - 1; i >= 0; i--) {
            clickRemoveButton(i);
        }
        System.out.println("Removed all items from cart");
    }

    /**
     * Check if plus button is visible for specific item
     * @param index cart item index
     * @return true if plus button is visible
     */
    public boolean isPlusButtonVisible(int index) {
        return index < plusButtons.size() && isElementDisplayed(plusButtons.get(index));
    }

    /**
     * Check if minus button is visible for specific item
     * @param index cart item index
     * @return true if minus button is visible
     */
    public boolean isMinusButtonVisible(int index) {
        return index < minusButtons.size() && isElementDisplayed(minusButtons.get(index));
    }

    /**
     * Check if remove button is visible for specific item
     * @param index cart item index
     * @return true if remove button is visible
     */
    public boolean isRemoveButtonVisible(int index) {
        return index < removeButtons.size() && isElementDisplayed(removeButtons.get(index));
    }

    /**
     * Verify all cart item controls are visible for specific item
     * @param index cart item index
     * @return true if plus, minus, and remove buttons are all visible
     */
    public boolean areCartItemControlsVisible(int index) {
        boolean plusVisible = isPlusButtonVisible(index);
        boolean minusVisible = isMinusButtonVisible(index);
        boolean removeVisible = isRemoveButtonVisible(index);

        System.out.println("Cart item " + index + " controls:");
        System.out.println("  Plus button visible: " + plusVisible);
        System.out.println("  Minus button visible: " + minusVisible);
        System.out.println("  Remove button visible: " + removeVisible);

        return plusVisible && minusVisible && removeVisible;
    }

    /**
     * Get total quantity of all items in cart
     * @return sum of all item quantities
     */
    public int getTotalQuantity() {
        int total = 0;
        for (int i = 0; i < getCartItemCount(); i++) {
            total += getItemQuantity(i);
        }
        return total;
    }
}

