package com.saucedemo.driver;

import com.saucedemo.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(ConfigReader.getPlatformName());
            options.setDeviceName(ConfigReader.getDeviceName());
            options.setPlatformVersion(ConfigReader.getPlatformVersion());
            options.setAutomationName("UiAutomator2");
            
            String appPath = ConfigReader.getAppPath();
            if (appPath != null && !appPath.isEmpty()) {
                options.setApp(System.getProperty("user.dir") + "/" + appPath);
            } else {
                options.setAppPackage(ConfigReader.getAppPackage());
                options.setAppActivity(ConfigReader.getAppActivity());
            }
            
            options.setNoReset(false);
            options.setFullReset(false);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            options.setAppWaitActivity("*");
            options.setAppWaitDuration(Duration.ofSeconds(30));
            options.setAutoGrantPermissions(true);
            options.setSkipDeviceInitialization(false);
            options.setSkipServerInstallation(false);

            AndroidDriver androidDriver = new AndroidDriver(
                    new URL(ConfigReader.getAppiumServerUrl()), 
                    options
            );

            androidDriver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));

            driver.set(androidDriver);
            System.out.println("Driver initialized successfully!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize driver: Invalid Appium Server URL");
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            System.out.println("Driver quit successfully!");
        }
    }
}

