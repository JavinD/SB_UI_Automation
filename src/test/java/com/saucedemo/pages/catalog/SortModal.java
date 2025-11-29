package com.saucedemo.pages.catalogpage;

import com.saucedemo.pages.general.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Sort Modal - Popup that appears when sort button is clicked on catalog page
 * Contains sorting options for products
 */
public class SortModal extends BasePage {

    // Sort by Name Ascending
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameAscCL")
    private WebElement sortNameAscButton;

    // Sort by Name Descending
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameDesCL")
    private WebElement sortNameDescButton;

    // Sort by Price Ascending
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceAscCL")
    private WebElement sortPriceAscButton;

    // Sort by Price Descending
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceDesCL")
    private WebElement sortPriceDescButton;

    /**
     * Check if sort modal is displayed
     * @return true if any sort button is visible
     */
    public boolean isSortModalDisplayed() {
        return isElementDisplayed(sortNameAscButton);
    }

    /**
     * Click on Name Ascending sort option
     */
    public void clickSortNameAscending() {
        waitForElementToBeClickable(sortNameAscButton);
        click(sortNameAscButton);
        System.out.println("Clicked on Sort Name Ascending");
        waitForSeconds(2); // Wait for sorting to complete
    }

    /**
     * Click on Name Descending sort option
     */
    public void clickSortNameDescending() {
        waitForElementToBeClickable(sortNameDescButton);
        click(sortNameDescButton);
        System.out.println("Clicked on Sort Name Descending");
        waitForSeconds(2); // Wait for sorting to complete
    }

    /**
     * Click on Price Ascending sort option
     */
    public void clickSortPriceAscending() {
        waitForElementToBeClickable(sortPriceAscButton);
        click(sortPriceAscButton);
        System.out.println("Clicked on Sort Price Ascending");
        waitForSeconds(2); // Wait for sorting to complete
    }

    /**
     * Click on Price Descending sort option
     */
    public void clickSortPriceDescending() {
        waitForElementToBeClickable(sortPriceDescButton);
        click(sortPriceDescButton);
        System.out.println("Clicked on Sort Price Descending");
        waitForSeconds(2); // Wait for sorting to complete
    }

    /**
     * Check if Name Ascending button is visible
     * @return true if button is displayed
     */
    public boolean isSortNameAscButtonVisible() {
        return isElementDisplayed(sortNameAscButton);
    }

    /**
     * Check if Name Descending button is visible
     * @return true if button is displayed
     */
    public boolean isSortNameDescButtonVisible() {
        return isElementDisplayed(sortNameDescButton);
    }

    /**
     * Check if Price Ascending button is visible
     * @return true if button is displayed
     */
    public boolean isSortPriceAscButtonVisible() {
        return isElementDisplayed(sortPriceAscButton);
    }

    /**
     * Check if Price Descending button is visible
     * @return true if button is displayed
     */
    public boolean isSortPriceDescButtonVisible() {
        return isElementDisplayed(sortPriceDescButton);
    }

    /**
     * Verify all sort options are visible
     * @return true if all 4 sort buttons are displayed
     */
    public boolean areAllSortOptionsVisible() {
        boolean nameAscVisible = isSortNameAscButtonVisible();
        boolean nameDescVisible = isSortNameDescButtonVisible();
        boolean priceAscVisible = isSortPriceAscButtonVisible();
        boolean priceDescVisible = isSortPriceDescButtonVisible();

        System.out.println("Name Asc visible: " + nameAscVisible);
        System.out.println("Name Desc visible: " + nameDescVisible);
        System.out.println("Price Asc visible: " + priceAscVisible);
        System.out.println("Price Desc visible: " + priceDescVisible);

        return nameAscVisible && nameDescVisible && priceAscVisible && priceDescVisible;
    }
}

