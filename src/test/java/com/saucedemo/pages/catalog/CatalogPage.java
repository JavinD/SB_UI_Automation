package com.saucedemo.pages.catalog;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends HeaderComponent {
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> productImages;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<WebElement> productTitles;
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<WebElement> productPrices;
    
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
    
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private WebElement sortButton;
    
    public boolean isCatalogPageDisplayed() {
        return isHeaderDisplayed();
    }
    
    public String getPageTitle() {
        return getText(productsTitle);
    }
    
    public void clickOnProductImage(int index) {
        if (index < productImages.size()) {
            click(productImages.get(index));
        } else {
            throw new IndexOutOfBoundsException("Product index " + index + " out of bounds. Total products: " + productImages.size());
        }
    }
    
    public void clickOnFirstProduct() {
        clickOnProductImage(0);
    }
    
    public String getProductTitle(int index) {
        if (index < productTitles.size()) {
            return getText(productTitles.get(index));
        }
        return "";
    }
    
    public String getProductPrice(int index) {
        if (index < productPrices.size()) {
            return getText(productPrices.get(index));
        }
        return "";
    }
    
    public String getProductRating(int index) {
        int starCount = 0;
        
        if (index < productStar1.size() && isElementDisplayed(productStar1.get(index))) starCount = 1;
        if (index < productStar2.size() && isElementDisplayed(productStar2.get(index))) starCount = 2;
        if (index < productStar3.size() && isElementDisplayed(productStar3.get(index))) starCount = 3;
        if (index < productStar4.size() && isElementDisplayed(productStar4.get(index))) starCount = 4;
        if (index < productStar5.size() && isElementDisplayed(productStar5.get(index))) starCount = 5;
        
        return starCount + " stars";
    }
    
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
    
    public boolean isSortButtonVisible() {
        return isElementDisplayed(sortButton);
    }
    
    public void clickSortButton() {
        waitForElementToBeClickable(sortButton);
        click(sortButton);
    }
    
    public boolean isSortButtonClickable() {
        try {
            waitForElementToBeClickable(sortButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public int getProductCount() {
        return productImages.size();
    }
    
    public java.util.List<String> getAllProductTitles() {
        java.util.List<String> titles = new java.util.ArrayList<>();
        for (int i = 0; i < productTitles.size(); i++) {
            titles.add(getText(productTitles.get(i)));
        }
        return titles;
    }
    
    public java.util.List<String> getAllProductPrices() {
        java.util.List<String> prices = new java.util.ArrayList<>();
        for (int i = 0; i < productPrices.size(); i++) {
            prices.add(getText(productPrices.get(i)));
        }
        return prices;
    }
    
    public double parsePriceToDouble(String priceString) {
        String cleanPrice = priceString.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }
    
    public boolean isProductInfoComplete(int index) {
        boolean hasTitle = !getProductTitle(index).isEmpty();
        boolean hasPrice = !getProductPrice(index).isEmpty();
        boolean hasRating = !getProductRating(index).equals("0 stars");
        
        return hasTitle && hasPrice && hasRating;
    }
}
