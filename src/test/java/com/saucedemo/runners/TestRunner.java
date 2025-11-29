package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner - Main entry point for running Cucumber tests
 * 
 * Configuration:
 * - features: Location of .feature files
 * - glue: Package containing step definitions
 * - plugin: Report formats and locations
 * - tags: Which scenarios to run (e.g., @smoke, @regression)
 * - monochrome: Makes console output more readable
 */
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
    // This class will be empty, it's just used to run the tests
}

