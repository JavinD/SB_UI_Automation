package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.saucedemo.steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "summary"
        },
        monochrome = true,
        tags = "@smoke",
        dryRun = false,
        snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
}
