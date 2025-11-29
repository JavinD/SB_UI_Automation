# Step-by-Step Fix Guide

## Issue 1: Install Appium UiAutomator2 Driver

Run these commands in PowerShell:

```powershell
# Step 1: Check installed drivers
appium driver list --installed

# Step 2: Install UiAutomator2 driver
appium driver install uiautomator2

# Step 3: Verify installation
appium driver list --installed
```

You should see:
```
✔ uiautomator2@X.X.X installed
```

## Issue 2: Verify Your Setup

### 1. Make sure Appium server is running:
```powershell
# Start Appium (keep this running in one terminal)
appium
```

### 2. Check your emulator/device:
```powershell
# In another terminal
adb devices
```

You should see your device listed, e.g.:
```
emulator-5554    device
```

### 3. Update config.properties

Make sure `src/test/resources/config.properties` has the correct values:

```properties
# Use the device name from 'adb devices'
deviceName=emulator-5554

# Use your actual Android version
platformVersion=14.0  # Change from 16.0 to your actual version

# Make sure APK path is correct
appPath=src/test/resources/app/MyDemoApp.apk
```

## Issue 3: Fix "Tests run: 0"

This happens because Maven/JUnit doesn't find Cucumber tests. Try these solutions:

### Solution A: Clean and rebuild
```powershell
mvn clean test
```

### Solution B: Run with specific test class
```powershell
mvn clean test -Dtest=TestRunner
```

### Solution C: Use alternate plugin
I've updated the TestRunner with additional configurations. Try running again:
```powershell
mvn clean test
```

## Complete Setup Checklist

- [ ] Install UiAutomator2 driver: `appium driver install uiautomator2`
- [ ] Start Appium server: `appium`
- [ ] Start emulator or connect device
- [ ] Verify device: `adb devices`
- [ ] Update config.properties with correct device name and platform version
- [ ] Place APK at: `src/test/resources/app/MyDemoApp.apk`
- [ ] Run tests: `mvn clean test`

## If Still Getting "Tests run: 0"

Try running directly from your IDE:
1. Right-click on `TestRunner.java`
2. Select "Run 'TestRunner'"

Or try with verbose output:
```powershell
mvn clean test -X
```

This will show detailed logs to see why tests aren't being picked up.

