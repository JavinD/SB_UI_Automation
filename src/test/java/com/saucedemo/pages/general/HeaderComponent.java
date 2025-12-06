package com.saucedemo.pages.general;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HeaderComponent extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/header")
    private WebElement headerContainer;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement menuButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/mTvTitle")
    protected WebElement headerTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/cartIV\")")
    private WebElement cartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement cartBadge;

    public boolean isHeaderDisplayed() {
        return isElementDisplayed(headerContainer);
    }

    public boolean isMenuButtonVisible() {
        return isElementDisplayed(menuButton);
    }

    public boolean isHeaderTitleVisible() {
        return isElementDisplayed(headerTitle);
    }

    public boolean isCartButtonVisible() {
        return isElementDisplayed(cartButton);
    }

    public boolean isCartBadgeVisible() {
        return isElementDisplayed(cartBadge);
    }

    public int getCartBadgeCount() {
        try {
            if (isCartBadgeVisible()) {
                String badgeText = getText(cartBadge);
                return Integer.parseInt(badgeText);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickMenu() {
        waitForElementToBeClickable(menuButton);
        click(menuButton);
    }

    public void clickCart() {
        waitForElementToBeClickable(cartButton);
        click(cartButton);
    }

    public boolean areMainHeaderElementsVisible() {
        return isMenuButtonVisible() && isHeaderTitleVisible() && isCartButtonVisible();
    }

    public boolean isMenuButtonClickable() {
        return isElementClickable(menuButton);
    }

    public boolean isCartButtonClickable() {
        return isElementClickable(cartButton);
    }

    public boolean areHeaderButtonsClickable() {
        return isMenuButtonClickable() && isCartButtonClickable();
    }
}
