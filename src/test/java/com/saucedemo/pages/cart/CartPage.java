package com.saucedemo.pages.cart;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private WebElement emptyCartTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> productImages;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<WebElement> productTitles;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<WebElement> productPrices;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private List<WebElement> quantityDisplays;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private List<WebElement> plusButtons;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private List<WebElement> minusButtons;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private List<WebElement> removeButtons;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement checkoutButton;

    public boolean isCartPageDisplayed() {
        return isHeaderDisplayed();
    }

    public boolean isCartEmpty() {
        return isElementDisplayed(emptyCartTitle);
    }

    public boolean hasItemsInCart() {
        return productImages != null && !productImages.isEmpty() && isElementDisplayed(productImages.get(0));
    }

    public String getEmptyCartMessage() {
        if (isCartEmpty()) {
            return getText(emptyCartTitle);
        }
        return "";
    }

    public int getCartItemCount() {
        if (hasItemsInCart()) {
            return productImages.size();
        }
        return 0;
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

    public int getItemQuantity(int index) {
        try {
            if (index < quantityDisplays.size()) {
                String quantityText = getText(quantityDisplays.get(index));
                return Integer.parseInt(quantityText);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickPlusButton(int index) {
        if (index < plusButtons.size()) {
            waitForElementToBeClickable(plusButtons.get(index));
            click(plusButtons.get(index));
            waitForSeconds(1);
        } else {
            throw new IndexOutOfBoundsException("Plus button index " + index + " out of bounds");
        }
    }

    public void clickMinusButton(int index) {
        if (index < minusButtons.size()) {
            waitForElementToBeClickable(minusButtons.get(index));
            click(minusButtons.get(index));
            waitForSeconds(1);
        } else {
            throw new IndexOutOfBoundsException("Minus button index " + index + " out of bounds");
        }
    }

    public void clickRemoveButton(int index) {
        if (index < removeButtons.size()) {
            waitForElementToBeClickable(removeButtons.get(index));
            click(removeButtons.get(index));
            waitForSeconds(1);
        } else {
            throw new IndexOutOfBoundsException("Remove button index " + index + " out of bounds");
        }
    }

    public void increaseFirstItemQuantity() {
        clickPlusButton(0);
    }

    public void decreaseFirstItemQuantity() {
        clickMinusButton(0);
    }

    public void removeFirstItem() {
        clickRemoveButton(0);
    }

    public void increaseItemQuantityBy(int index, int times) {
        for (int i = 0; i < times; i++) {
            clickPlusButton(index);
        }
    }

    public void decreaseItemQuantityBy(int index, int times) {
        for (int i = 0; i < times; i++) {
            clickMinusButton(index);
        }
    }

    public boolean isCheckoutButtonVisible() {
        return isElementDisplayed(checkoutButton);
    }

    public boolean isCheckoutButtonClickable() {
        try {
            waitForElementToBeClickable(checkoutButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCheckoutButton() {
        waitForElementToBeClickable(checkoutButton);
        click(checkoutButton);
        waitForSeconds(2);
    }

    public void removeAllItems() {
        int itemCount = getCartItemCount();
        for (int i = itemCount - 1; i >= 0; i--) {
            clickRemoveButton(i);
        }
    }

    public boolean isPlusButtonVisible(int index) {
        return index < plusButtons.size() && isElementDisplayed(plusButtons.get(index));
    }

    public boolean isMinusButtonVisible(int index) {
        return index < minusButtons.size() && isElementDisplayed(minusButtons.get(index));
    }

    public boolean isRemoveButtonVisible(int index) {
        return index < removeButtons.size() && isElementDisplayed(removeButtons.get(index));
    }

    public boolean areCartItemControlsVisible(int index) {
        return isPlusButtonVisible(index) && isMinusButtonVisible(index) && isRemoveButtonVisible(index);
    }

    public int getTotalQuantity() {
        int total = 0;
        for (int i = 0; i < getCartItemCount(); i++) {
            total += getItemQuantity(i);
        }
        return total;
    }
}
