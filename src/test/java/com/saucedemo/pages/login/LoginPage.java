package com.saucedemo.pages.login;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * Login Page - Allows users to login before proceeding to checkout
 * Accessible from cart page when clicking checkout button
 * Extends HeaderComponent to inherit header functionality
 */
public class LoginPage extends HeaderComponent {

    // Username input field
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameInput;

    // Password input field
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordInput;

    // Login button
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    // Login title (optional - for page verification)
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private WebElement loginTitle;

    /**
     * Check if login page is displayed
     * @return true if login page is visible
     */
    public boolean isLoginPageDisplayed() {
        return isElementDisplayed(usernameInput) && isElementDisplayed(passwordInput) && isElementDisplayed(loginButton);
    }

    /**
     * Check if username input is visible
     * @return true if username field is displayed
     */
    public boolean isUsernameInputVisible() {
        return isElementDisplayed(usernameInput);
    }

    /**
     * Check if password input is visible
     * @return true if password field is displayed
     */
    public boolean isPasswordInputVisible() {
        return isElementDisplayed(passwordInput);
    }

    /**
     * Check if login button is visible
     * @return true if login button is displayed
     */
    public boolean isLoginButtonVisible() {
        return isElementDisplayed(loginButton);
    }

    /**
     * Enter username
     * @param username username to enter
     */
    public void enterUsername(String username) {
        waitForElementToBeVisible(usernameInput);
        sendKeys(usernameInput, username);
        System.out.println("Entered username: " + username);
    }

    /**
     * Enter password
     * @param password password to enter
     */
    public void enterPassword(String password) {
        waitForElementToBeVisible(passwordInput);
        sendKeys(passwordInput, password);
        System.out.println("Entered password: " + password);
    }

    /**
     * Click login button
     */
    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        click(loginButton);
        System.out.println("Clicked login button");
        waitForSeconds(2); // Wait for navigation/validation
    }

    /**
     * Get username input value
     * @return username text
     */
    public String getUsernameValue() {
        waitForElementToBeVisible(usernameInput);
        return usernameInput.getText();
    }

    /**
     * Get password input value
     * @return password text
     */
    public String getPasswordValue() {
        waitForElementToBeVisible(passwordInput);
        return passwordInput.getText();
    }

    /**
     * Check if username field is empty
     * @return true if username is empty
     */
    public boolean isUsernameEmpty() {
        String username = getUsernameValue();
        return username == null || username.trim().isEmpty();
    }

    /**
     * Check if password field is empty
     * @return true if password is empty
     */
    public boolean isPasswordEmpty() {
        String password = getPasswordValue();
        return password == null || password.trim().isEmpty();
    }

    /**
     * Clear username field
     */
    public void clearUsername() {
        waitForElementToBeVisible(usernameInput);
        usernameInput.clear();
        System.out.println("Cleared username field");
    }

    /**
     * Clear password field
     */
    public void clearPassword() {
        waitForElementToBeVisible(passwordInput);
        passwordInput.clear();
        System.out.println("Cleared password field");
    }

    /**
     * Clear all input fields
     */
    public void clearAllFields() {
        clearUsername();
        clearPassword();
    }

    /**
     * Perform login with username and password
     * @param username username
     * @param password password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        System.out.println("Performed login with username: " + username);
    }

    /**
     * Check if login button is clickable
     * @return true if login button is clickable
     */
    public boolean isLoginButtonClickable() {
        try {
            waitForElementToBeClickable(loginButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verify all login page elements are visible
     * @return true if all elements are visible
     */
    public boolean areAllLoginElementsVisible() {
        boolean usernameVisible = isUsernameInputVisible();
        boolean passwordVisible = isPasswordInputVisible();
        boolean loginButtonVisible = isLoginButtonVisible();

        System.out.println("Username input visible: " + usernameVisible);
        System.out.println("Password input visible: " + passwordVisible);
        System.out.println("Login button visible: " + loginButtonVisible);

        return usernameVisible && passwordVisible && loginButtonVisible;
    }

    /**
     * Get login title text (if available)
     * @return login title text
     */
    public String getLoginTitle() {
        try {
            if (isElementDisplayed(loginTitle)) {
                return getText(loginTitle);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }
}

