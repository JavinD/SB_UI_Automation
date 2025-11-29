package com.saucedemo.driver;

import com.saucedemo.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

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
            
            // Use app path if available, otherwise use package and activity
            String appPath = ConfigReader.getAppPath();
            if (appPath != null && !appPath.isEmpty()) {
                options.setApp(System.getProperty("user.dir") + "/" + appPath);
            } else {
                options.setAppPackage(ConfigReader.getAppPackage());
                options.setAppActivity(ConfigReader.getAppActivity());
            }
            
            // Additional capabilities
            options.setNoReset(false);
            options.setFullReset(false);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            
            // Activity/App launch settings - helps with SplashActivity issues
            options.setAppWaitActivity("*");  // Wait for any activity
            options.setAppWaitDuration(Duration.ofSeconds(30));  // Wait up to 30 seconds
            options.setAutoGrantPermissions(true);  // Auto-grant app permissions
            
            // Optional: Skip device initialization to speed up
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

