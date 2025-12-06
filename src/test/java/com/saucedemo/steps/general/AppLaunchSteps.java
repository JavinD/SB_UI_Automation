package com.saucedemo.steps.general;

import com.saucedemo.pages.catalog.CatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AppLaunchSteps {

    private CatalogPage catalogPage;

    @Given("the app is launched")
    public void theAppIsLaunched() {
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
        Assert.assertTrue("Catalog page is not displayed!", isDisplayed);
    }
}
