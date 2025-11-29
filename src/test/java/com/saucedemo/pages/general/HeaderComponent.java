package com.saucedemo.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Header Component - Common header across multiple pages
 * Contains menu, title, cart buttons, and cart badge
 */
public class HeaderComponent extends BasePage {

    // Header container
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/header")
    private WebElement headerContainer;

    // Menu button (hamburger icon)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement menuButton;

    // Header title (protected so child classes can access)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/mTvTitle")
    protected WebElement headerTitle;

    // Cart button
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartIV\")")
    private WebElement cartButton;

    // Cart badge - shows number of items in cart (not visible when cart is empty)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement cartBadge;

    /**
     * Check if header is displayed
     * @return true if header container is visible
     */
    public boolean isHeaderDisplayed() {
        return isElementDisplayed(headerContainer);
    }

    /**
     * Check if menu button is visible
     * @return true if menu button is displayed
     */
    public boolean isMenuButtonVisible() {
        return isElementDisplayed(menuButton);
    }

    /**
     * Check if header title is visible
     * @return true if header title is displayed
     */
    public boolean isHeaderTitleVisible() {
        return isElementDisplayed(headerTitle);
    }

    /**
     * Check if cart button is visible
     * @return true if cart button is displayed
     */
    public boolean isCartButtonVisible() {
        return isElementDisplayed(cartButton);
    }

    /**
     * Check if cart badge is visible
     * Cart badge only appears when there are items in the cart
     * @return true if cart badge is displayed
     */
    public boolean isCartBadgeVisible() {
        return isElementDisplayed(cartBadge);
    }

    /**
     * Get cart badge count
     * @return cart item count as integer, or 0 if badge not visible
     */
    public int getCartBadgeCount() {
        try {
            if (isCartBadgeVisible()) {
                String badgeText = getText(cartBadge);
                return Integer.parseInt(badgeText);
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Could not read cart badge: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Click on menu button
     */
    public void clickMenu() {
        waitForElementToBeClickable(menuButton);
        click(menuButton);
        System.out.println("Clicked on menu button");
    }

    /**
     * Click on cart button
     */
    public void clickCart() {
        waitForElementToBeClickable(cartButton);
        click(cartButton);
        System.out.println("Clicked on cart button");
    }

    /**
     * Verify all main header elements are visible
     * @return true if menu, header title, and cart are visible
     */
    public boolean areMainHeaderElementsVisible() {
        boolean menuVisible = isMenuButtonVisible();
        boolean titleVisible = isHeaderTitleVisible();
        boolean cartVisible = isCartButtonVisible();

        System.out.println("Menu visible: " + menuVisible);
        System.out.println("Header title visible: " + titleVisible);
        System.out.println("Cart visible: " + cartVisible);

        return menuVisible && titleVisible && cartVisible;
    }

    public boolean isMenuButtonClickable() {
        return isElementClickable(menuButton);
    }

    public boolean isCartButtonClickable() {
        return isElementClickable(cartButton);
    }

    /**
     * Verify all header buttons are clickable
     * @return true if menu and cart buttons are clickable
     */
    public boolean areHeaderButtonsClickable() {
        boolean menuClickable = isMenuButtonClickable();
        boolean cartClickable = isCartButtonClickable();

        System.out.println("Menu clickable: " + menuClickable);
        System.out.println("Cart clickable: " + cartClickable);

        return menuClickable && cartClickable;
    }
}
