package com.saucedemo.steps.general;

import com.saucedemo.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        try {
            DriverManager.initializeDriver();
            disableAnimations();
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }
    }

    private void disableAnimations() {
        try {
            Runtime.getRuntime().exec("adb shell settings put global window_animation_scale 0");
            Runtime.getRuntime().exec("adb shell settings put global transition_animation_scale 0");
            Runtime.getRuntime().exec("adb shell settings put global animator_duration_scale 0");
        } catch (Exception e) {
            // Animations couldn't be disabled
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        DriverManager.quitDriver();
    }
}
