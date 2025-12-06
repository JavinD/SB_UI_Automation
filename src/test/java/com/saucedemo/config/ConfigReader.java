package com.saucedemo.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file at: " + CONFIG_FILE_PATH, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getPlatformName() {
        return properties.getProperty("platformName");
    }

    public static String getDeviceName() {
        return properties.getProperty("deviceName");
    }

    public static String getPlatformVersion() {
        return properties.getProperty("platformVersion");
    }

    public static String getAppPath() {
        return properties.getProperty("appPath");
    }

    public static String getAppPackage() {
        return properties.getProperty("appPackage");
    }

    public static String getAppActivity() {
        return properties.getProperty("appActivity");
    }

    public static String getAppiumServerUrl() {
        return properties.getProperty("appiumServerUrl");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitWait", "10"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait", "20"));
    }

    public static String getValidUsername() {
        return properties.getProperty("validUsername");
    }

    public static String getValidPassword() {
        return properties.getProperty("validPassword");
    }
}
