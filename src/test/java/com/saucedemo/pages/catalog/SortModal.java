package com.saucedemo.pages.catalog;

import com.saucedemo.pages.general.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SortModal extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameAscCL")
    private WebElement sortNameAscButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameDesCL")
    private WebElement sortNameDescButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceAscCL")
    private WebElement sortPriceAscButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceDesCL")
    private WebElement sortPriceDescButton;

    public boolean isSortModalDisplayed() {
        return isElementDisplayed(sortNameAscButton);
    }

    public void clickSortNameAscending() {
        waitForElementToBeClickable(sortNameAscButton);
        click(sortNameAscButton);
        waitForSeconds(2);
    }

    public void clickSortNameDescending() {
        waitForElementToBeClickable(sortNameDescButton);
        click(sortNameDescButton);
        waitForSeconds(2);
    }

    public void clickSortPriceAscending() {
        waitForElementToBeClickable(sortPriceAscButton);
        click(sortPriceAscButton);
        waitForSeconds(2);
    }

    public void clickSortPriceDescending() {
        waitForElementToBeClickable(sortPriceDescButton);
        click(sortPriceDescButton);
        waitForSeconds(2);
    }

    public boolean isSortNameAscButtonVisible() {
        return isElementDisplayed(sortNameAscButton);
    }

    public boolean isSortNameDescButtonVisible() {
        return isElementDisplayed(sortNameDescButton);
    }

    public boolean isSortPriceAscButtonVisible() {
        return isElementDisplayed(sortPriceAscButton);
    }

    public boolean isSortPriceDescButtonVisible() {
        return isElementDisplayed(sortPriceDescButton);
    }

    public boolean areAllSortOptionsVisible() {
        return isSortNameAscButtonVisible() && isSortNameDescButtonVisible() 
            && isSortPriceAscButtonVisible() && isSortPriceDescButtonVisible();
    }
}
