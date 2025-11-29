package com.saucedemo.pages.catalog;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Catalog/Products Page - First page after app launch
 * Displays list of products with ability to sort, filter, and add to cart
 * Extends HeaderComponent to inherit header functionality
 */
public class CatalogPage extends HeaderComponent {
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;
    
    // Product Images (List for multiple products)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> productImages;
    
    // Product Titles (List for multiple products)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<WebElement> productTitles;
    
    // Product Prices (List for multiple products)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<WebElement> productPrices;
    
    // Product Rating Stars (Individual stars 1-5)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/start1IV")
    private List<WebElement> productStar1;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/start2IV")
    private List<WebElement> productStar2;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/start3IV")
    private List<WebElement> productStar3;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/start4IV")
    private List<WebElement> productStar4;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/start5IV")
    private List<WebElement> productStar5;
    
    // Sort button (specific to catalog page)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private WebElement sortButton;
    
    /**
     * Check if catalog page is displayed
     * Uses inherited isHeaderDisplayed() from HeaderComponent
     * @return true if page is displayed
     */
    public boolean isCatalogPageDisplayed() {
        return isHeaderDisplayed();
    }
    
    
    /**
     * Get the catalog page specific title (from productsTitle element)
     * @return page title (should be "Products")
     */
    public String getPageTitle() {
        return getText(productsTitle);
    }
    
    /**
     * Click on a product image by index
     * @param index - index of the product (0-based)
     */
    public void clickOnProductImage(int index) {
        if (index < productImages.size()) {
            click(productImages.get(index));
        } else {
            throw new IndexOutOfBoundsException("Product index " + index + " out of bounds. Total products: " + productImages.size());
        }
    }
    
    /**
     * Click on the first product image
     */
    public void clickOnFirstProduct() {
        clickOnProductImage(0);
    }
    
    /**
     * Get product title by index
     * @param index - index of the product (0-based)
     * @return product title text
     */
    public String getProductTitle(int index) {
        if (index < productTitles.size()) {
            return getText(productTitles.get(index));
        }
        return "";
    }
    
    /**
     * Get product price by index
     * @param index - index of the product (0-based)
     * @return product price text
     */
    public String getProductPrice(int index) {
        if (index < productPrices.size()) {
            return getText(productPrices.get(index));
        }
        return "";
    }
    
    /**
     * Get product rating by index (checks star visibility)
     * @param index - index of the product (0-based)
     * @return rating as string (e.g., "5 stars", "3 stars")
     */
    public String getProductRating(int index) {
        int starCount = 0;
        
        if (index < productStar1.size() && isElementDisplayed(productStar1.get(index))) starCount = 1;
        if (index < productStar2.size() && isElementDisplayed(productStar2.get(index))) starCount = 2;
        if (index < productStar3.size() && isElementDisplayed(productStar3.get(index))) starCount = 3;
        if (index < productStar4.size() && isElementDisplayed(productStar4.get(index))) starCount = 4;
        if (index < productStar5.size() && isElementDisplayed(productStar5.get(index))) starCount = 5;
        
        return starCount + " stars";
    }
    
    /**
     * Get individual star element visibility
     * @param index - product index
     * @param starNumber - star number (1-5)
     * @return true if star is visible
     */
    public boolean isStarVisible(int index, int starNumber) {
        switch (starNumber) {
            case 1: return index < productStar1.size() && isElementDisplayed(productStar1.get(index));
            case 2: return index < productStar2.size() && isElementDisplayed(productStar2.get(index));
            case 3: return index < productStar3.size() && isElementDisplayed(productStar3.get(index));
            case 4: return index < productStar4.size() && isElementDisplayed(productStar4.get(index));
            case 5: return index < productStar5.size() && isElementDisplayed(productStar5.get(index));
            default: return false;
        }
    }
    
    /**
     * Check if sort button is visible
     * @return true if sort button is displayed
     */
    public boolean isSortButtonVisible() {
        return isElementDisplayed(sortButton);
    }
    
    /**
     * Click on the sort button
     */
    public void clickSortButton() {
        waitForElementToBeClickable(sortButton);
        click(sortButton);
        System.out.println("Clicked on sort button");
    }
    
    /**
     * Check if sort button is clickable
     * @return true if sort button is clickable
     */
    public boolean isSortButtonClickable() {
        try {
            waitForElementToBeClickable(sortButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get total number of products displayed
     * @return number of products
     */
    public int getProductCount() {
        return productImages.size();
    }
    
    /**
     * Get all product titles as a list
     * @return list of all product title strings
     */
    public java.util.List<String> getAllProductTitles() {
        java.util.List<String> titles = new java.util.ArrayList<>();
        for (int i = 0; i < productTitles.size(); i++) {
            titles.add(getText(productTitles.get(i)));
        }
        System.out.println("Retrieved " + titles.size() + " product titles");
        return titles;
    }
    
    /**
     * Get all product prices as a list
     * @return list of all product price strings
     */
    public java.util.List<String> getAllProductPrices() {
        java.util.List<String> prices = new java.util.ArrayList<>();
        for (int i = 0; i < productPrices.size(); i++) {
            prices.add(getText(productPrices.get(i)));
        }
        System.out.println("Retrieved " + prices.size() + " product prices");
        return prices;
    }
    
    /**
     * Convert price string to double for comparison
     * Example: "$ 29.99" -> 29.99
     * @param priceString the price string from UI
     * @return price as double
     */
    public double parsePriceToDouble(String priceString) {
        // Remove "$" and spaces, then parse to double
        String cleanPrice = priceString.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }
    
    /**
     * Check if product at index has all information displayed
     * @param index - index of the product (0-based)
     * @return true if title, price, and rating are all present
     */
    public boolean isProductInfoComplete(int index) {
        boolean hasTitle = !getProductTitle(index).isEmpty();
        boolean hasPrice = !getProductPrice(index).isEmpty();
        boolean hasRating = !getProductRating(index).equals("0 stars");
        
        return hasTitle && hasPrice && hasRating;
    }
}

