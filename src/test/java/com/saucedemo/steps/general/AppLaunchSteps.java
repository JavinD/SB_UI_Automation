package com.saucedemo.steps.general;

import com.saucedemo.pages.catalogpage.CatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

/**
 * Step definitions for app launch verification
 * Simple test to verify the app opens successfully
 */
public class AppLaunchSteps {

    private CatalogPage catalogPage;

    @Given("the app is launched")
    public void theAppIsLaunched() {
        // Driver initialization is handled in Hooks
        System.out.println("App launched successfully");
        
        // Give app time to fully load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the catalog page")
    public void iShouldSeeTheCatalogPage() {
        catalogPage = new CatalogPage();
        boolean isDisplayed = catalogPage.isCatalogPageDisplayed();
        
        Assert.assertTrue("Catalog page is not displayed! App may not have loaded correctly.", isDisplayed);
        System.out.println("Catalog page is displayed");
    }
}
