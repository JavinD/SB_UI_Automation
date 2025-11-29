package com.saucedemo.steps.general;

import com.saucedemo.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("========================================");
        System.out.println("Starting Scenario: " + scenario.getName());
        System.out.println("========================================");
        
        try {
            DriverManager.initializeDriver();
            disableAnimations();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Driver initialization failed", e);
        }
    }

    private void disableAnimations() {
        try {
            Runtime.getRuntime().exec("adb shell settings put global window_animation_scale 0");
            Runtime.getRuntime().exec("adb shell settings put global transition_animation_scale 0");
            Runtime.getRuntime().exec("adb shell settings put global animator_duration_scale 0");
            System.out.println("Animations disabled for faster test execution");
        } catch (Exception e) {
            System.out.println("Could not disable animations: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario FAILED: " + scenario.getName());
        } else {
            System.out.println("Scenario PASSED: " + scenario.getName());
        }
        System.out.println("========================================");
        DriverManager.quitDriver();
    }
}

