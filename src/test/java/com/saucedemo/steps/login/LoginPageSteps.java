package com.saucedemo.steps.login;

import com.saucedemo.config.ConfigReader;
import com.saucedemo.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * Step definitions for Login Page functionality
 * Tests login scenarios with valid and invalid credentials
 */
public class LoginPageSteps {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage = new LoginPage();
        boolean isDisplayed = loginPage.isLoginPageDisplayed();
        Assert.assertTrue("Login page is not displayed", isDisplayed);
        System.out.println("User is on login page");
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPage() {
        iAmOnTheLoginPage();
    }

    @Then("all login page elements should be visible")
    public void allLoginPageElementsShouldBeVisible() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        boolean allVisible = loginPage.areAllLoginElementsVisible();
        Assert.assertTrue("Not all login page elements are visible", allVisible);
        System.out.println("All login page elements are visible");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Check if username is a config reference
        if (username.equals("from_config") || username.equals("config")) {
            username = ConfigReader.getValidUsername();
        }

        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Check if password is a config reference
        if (password.equals("from_config") || password.equals("config")) {
            password = ConfigReader.getValidPassword();
        }

        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        loginPage.clickLoginButton();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Check if username/password are config references
        if (username.equals("from_config") || username.equals("config")) {
            username = ConfigReader.getValidUsername();
        }
        if (password.equals("from_config") || password.equals("config")) {
            password = ConfigReader.getValidPassword();
        }

        loginPage.login(username, password);
    }

    @When("I leave username empty")
    public void iLeaveUsernameEmpty() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Clear username field if it has any value
        loginPage.clearUsername();
    }

    @When("I leave password empty")
    public void iLeavePasswordEmpty() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Clear password field if it has any value
        loginPage.clearPassword();
    }

    @Then("the username field should be empty")
    public void theUsernameFieldShouldBeEmpty() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        boolean isEmpty = loginPage.isUsernameEmpty();
        Assert.assertTrue("Username field is not empty", isEmpty);
        System.out.println("Username field is empty");
    }

    @Then("the password field should be empty")
    public void thePasswordFieldShouldBeEmpty() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        boolean isEmpty = loginPage.isPasswordEmpty();
        Assert.assertTrue("Password field is not empty", isEmpty);
        System.out.println("Password field is empty");
    }

    @Then("the login button should be visible")
    public void theLoginButtonShouldBeVisible() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        boolean isVisible = loginPage.isLoginButtonVisible();
        Assert.assertTrue("Login button is not visible", isVisible);
        System.out.println("Login button is visible");
    }

    @Then("the login button should be clickable")
    public void theLoginButtonShouldBeClickable() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        boolean isClickable = loginPage.isLoginButtonClickable();
        Assert.assertTrue("Login button is not clickable", isClickable);
        System.out.println("Login button is clickable");
    }

    @Then("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        // Wait a moment to ensure no navigation happened
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isStillOnLoginPage = loginPage.isLoginPageDisplayed();
        Assert.assertTrue("User was redirected away from login page", isStillOnLoginPage);
        System.out.println("User remained on login page (validation failed as expected)");
    }

    @When("I clear all login fields")
    public void iClearAllLoginFields() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        loginPage.clearAllFields();
    }
}

