package com.saucedemo.pages.login;

import com.saucedemo.pages.general.HeaderComponent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends HeaderComponent {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement usernameInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private WebElement loginTitle;

    public boolean isLoginPageDisplayed() {
        return isElementDisplayed(usernameInput) && isElementDisplayed(passwordInput) && isElementDisplayed(loginButton);
    }

    public boolean isUsernameInputVisible() {
        return isElementDisplayed(usernameInput);
    }

    public boolean isPasswordInputVisible() {
        return isElementDisplayed(passwordInput);
    }

    public boolean isLoginButtonVisible() {
        return isElementDisplayed(loginButton);
    }

    public void enterUsername(String username) {
        waitForElementToBeVisible(usernameInput);
        sendKeys(usernameInput, username);
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(passwordInput);
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(loginButton);
        click(loginButton);
        waitForSeconds(2);
    }

    public String getUsernameValue() {
        waitForElementToBeVisible(usernameInput);
        return usernameInput.getText();
    }

    public String getPasswordValue() {
        waitForElementToBeVisible(passwordInput);
        return passwordInput.getText();
    }

    public boolean isUsernameEmpty() {
        String username = getUsernameValue();
        return username == null || username.trim().isEmpty();
    }

    public boolean isPasswordEmpty() {
        String password = getPasswordValue();
        return password == null || password.trim().isEmpty();
    }

    public void clearUsername() {
        waitForElementToBeVisible(usernameInput);
        usernameInput.clear();
    }

    public void clearPassword() {
        waitForElementToBeVisible(passwordInput);
        passwordInput.clear();
    }

    public void clearAllFields() {
        clearUsername();
        clearPassword();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoginButtonClickable() {
        try {
            waitForElementToBeClickable(loginButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areAllLoginElementsVisible() {
        return isUsernameInputVisible() && isPasswordInputVisible() && isLoginButtonVisible();
    }

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
