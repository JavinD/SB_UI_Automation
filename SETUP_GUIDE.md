# My Demo App - Android UI Automation Setup Guide

This guide will help you set up and run the UI automation tests for the My Demo App Android application using Java, Cucumber, and Appium.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

### 1. Java Development Kit (JDK)
- **Version**: JDK 11 or higher
- **Download**: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **Verify Installation**:
  ```bash
  java -version
  javac -version
  ```

### 2. Maven
- **Version**: 3.6 or higher
- **Download**: [Apache Maven](https://maven.apache.org/download.cgi)
- **Installation**:
  - Windows: Download and extract, add `bin` folder to PATH
  - Mac: `brew install maven`
  - Linux: `sudo apt install maven`
- **Verify Installation**:
  ```bash
  mvn -version
  ```

### 3. Node.js and npm
- **Version**: Node.js 14 or higher
- **Download**: [Node.js](https://nodejs.org/)
- **Verify Installation**:
  ```bash
  node --version
  npm --version
  ```

### 4. Appium Server
- **Install globally using npm**:
  ```bash
  npm install -g appium@next
  ```
- **Install Appium Doctor** (for diagnostics):
  ```bash
  npm install -g appium-doctor
  ```
- **Verify Installation**:
  ```bash
  appium --version
  ```

### 5. Appium UiAutomator2 Driver
- **Install the driver**:
  ```bash
  appium driver install uiautomator2
  ```

### 6. Android SDK and Tools

#### Option A: Android Studio (Recommended)
- **Download**: [Android Studio](https://developer.android.com/studio)
- **Install Android SDK through Android Studio**:
  1. Open Android Studio
  2. Go to Settings/Preferences → Appearance & Behavior → System Settings → Android SDK
  3. Install the required SDK Platform (Android 11 or 12)
  4. Install Android SDK Build-Tools
  5. Install Android SDK Platform-Tools

#### Option B: Command Line Tools Only
- **Download**: [Android Command Line Tools](https://developer.android.com/studio#command-tools)
- **Install required packages**:
  ```bash
  sdkmanager "platform-tools" "platforms;android-31" "build-tools;31.0.0"
  ```

### 7. Set Environment Variables

#### Windows:
```powershell
# Set JAVA_HOME
setx JAVA_HOME "C:\Program Files\Java\jdk-11.0.x"

# Set ANDROID_HOME
setx ANDROID_HOME "C:\Users\YourUsername\AppData\Local\Android\Sdk"

# Add to PATH
setx PATH "%PATH%;%JAVA_HOME%\bin;%ANDROID_HOME%\platform-tools;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin"
```

#### Mac/Linux:
Add to `~/.bash_profile` or `~/.zshrc`:
```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.x.jdk/Contents/Home
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin
```

Then run:
```bash
source ~/.bash_profile  # or source ~/.zshrc
```

### 8. Android Emulator or Real Device

#### Option A: Android Emulator (via Android Studio)
1. Open Android Studio
2. Go to Tools → AVD Manager
3. Create a new Virtual Device
4. Select a device definition (e.g., Pixel 5)
5. Download and select a system image (Android 11 or 12 recommended)
6. Finish setup and launch the emulator

#### Option B: Real Android Device
1. Enable Developer Options on your device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
2. Enable USB Debugging in Developer Options
3. Connect device via USB
4. Verify connection:
   ```bash
   adb devices
   ```

### 9. Verify Setup with Appium Doctor
```bash
appium-doctor --android
```
This will check if all requirements are met. Fix any issues before proceeding.

## Project Setup

### 1. Clone or Download the Project
```bash
cd D:\Javin\Job\SB\SB_UI_Automation\SB_UI_Automation
```

### 2. Download the My Demo App APK

You have two options:

#### Option A: Download from Releases
1. Visit: https://github.com/saucelabs/my-demo-app-android/releases
2. Download the latest APK file (e.g., `app-release.apk`)
3. Create the directory structure:
   ```bash
   mkdir -p src/test/resources/app
   ```
4. Copy the APK to: `src/test/resources/app/MyDemoApp.apk`

#### Option B: Build from Source
```bash
git clone https://github.com/saucelabs/my-demo-app-android.git
cd my-demo-app-android
./gradlew assembleDebug
# Copy the generated APK to your test project
cp app/build/outputs/apk/debug/app-debug.apk ../SB_UI_Automation/src/test/resources/app/MyDemoApp.apk
```

### 3. Install Maven Dependencies
```bash
mvn clean install -DskipTests
```

This will download all required dependencies including:
- Appium Java Client
- Cucumber Java & JUnit
- Selenium WebDriver
- Other utility libraries

### 4. Configure Test Properties

Edit `src/test/resources/config.properties`:

```properties
# Appium Server Configuration
appiumServerUrl=http://127.0.0.1:4723

# Android Configuration
platformName=Android
deviceName=Android Emulator  # Or your device name from 'adb devices'
platformVersion=12.0  # Match your emulator/device version
automationName=UiAutomator2

# Application Configuration
appPackage=com.saucelabs.mydemoapp.android
appActivity=com.saucelabs.mydemoapp.android.view.activities.SplashActivity
appPath=src/test/resources/app/MyDemoApp.apk

# Wait Times (in seconds)
implicitWait=10
explicitWait=20

# Test Data
validUsername=bob@example.com
validPassword=10203040
```

### 5. Update Device Configuration

Run this command to see available devices:
```bash
adb devices
```

Update the `deviceName` in `config.properties` with your device name.

For emulator, you can use:
```bash
emulator -list-avds
```

## Running the Tests

### 1. Start Appium Server

Open a new terminal and start Appium:
```bash
appium
```

Or start with specific host and port:
```bash
appium --address 127.0.0.1 --port 4723
```

Keep this terminal running.

### 2. Start Android Emulator (if using emulator)

```bash
emulator -avd <emulator_name>
```

Or launch from Android Studio AVD Manager.

### 3. Run All Tests
```bash
mvn clean test
```

### 4. Run Specific Tags

Run only smoke tests:
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

Run product-related tests:
```bash
mvn clean test -Dcucumber.filter.tags="@products"
```

Run cart tests:
```bash
mvn clean test -Dcucumber.filter.tags="@cart"
```

Run login tests:
```bash
mvn clean test -Dcucumber.filter.tags="@login"
```

### 5. Run Specific Feature File

```bash
mvn clean test -Dcucumber.features="src/test/resources/features/ProductCatalog.feature"
```

### 6. Run Tests from IDE

#### IntelliJ IDEA:
1. Right-click on `TestRunner.java`
2. Select "Run 'TestRunner'"

#### Eclipse:
1. Right-click on `TestRunner.java`
2. Select "Run As" → "JUnit Test"

## Test Reports

After test execution, reports will be generated in:
- **HTML Report**: `target/cucumber-reports/cucumber.html`
- **JSON Report**: `target/cucumber-reports/cucumber.json`
- **XML Report**: `target/cucumber-reports/cucumber.xml`
- **Screenshots** (on failure): `target/screenshots/`

Open the HTML report in a browser:
```bash
# Windows
start target/cucumber-reports/cucumber.html

# Mac
open target/cucumber-reports/cucumber.html

# Linux
xdg-open target/cucumber-reports/cucumber.html
```

## Project Structure

```
SB_UI_Automation/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── saucedemo/
│       │           ├── config/
│       │           │   └── ConfigReader.java
│       │           ├── driver/
│       │           │   └── DriverManager.java
│       │           ├── pages/
│       │           │   ├── BasePage.java
│       │           │   ├── ProductsPage.java
│       │           │   ├── ProductDetailsPage.java
│       │           │   ├── CartPage.java
│       │           │   ├── LoginPage.java
│       │           │   └── MenuPage.java
│       │           ├── steps/
│       │           │   ├── CommonSteps.java
│       │           │   ├── ProductCatalogSteps.java
│       │           │   ├── ShoppingCartSteps.java
│       │           │   ├── LoginSteps.java
│       │           │   ├── MenuSteps.java
│       │           │   └── Hooks.java
│       │           └── runners/
│       │               └── TestRunner.java
│       └── resources/
│           ├── features/
│           │   ├── ProductCatalog.feature
│           │   ├── ShoppingCart.feature
│           │   ├── UserLogin.feature
│           │   └── Menu.feature
│           ├── app/
│           │   └── MyDemoApp.apk
│           └── config.properties
├── pom.xml
├── .gitignore
├── README.md
└── SETUP_GUIDE.md
```

## Troubleshooting

### 1. Appium Server Not Starting
```bash
# Kill any existing Appium processes
# Windows
taskkill /F /IM node.exe

# Mac/Linux
killall node

# Restart Appium
appium
```

### 2. Device Not Found
```bash
# Check connected devices
adb devices

# Restart ADB server
adb kill-server
adb start-server
adb devices
```

### 3. App Installation Failed
```bash
# Manually install the APK
adb install -r src/test/resources/app/MyDemoApp.apk

# Check if app is installed
adb shell pm list packages | grep saucelabs
```

### 4. Element Not Found Errors
- Increase wait times in `config.properties`
- Check if app package/activity names are correct
- Use Appium Inspector to verify element locators

### 5. Maven Build Errors
```bash
# Clear Maven cache and rebuild
mvn clean
mvn dependency:purge-local-repository
mvn clean install
```

### 6. Port Already in Use
```bash
# Change Appium port
appium --address 127.0.0.1 --port 4724

# Update config.properties
appiumServerUrl=http://127.0.0.1:4724
```

## Useful Commands

### ADB Commands
```bash
# List devices
adb devices

# Install APK
adb install path/to/app.apk

# Uninstall app
adb uninstall com.saucelabs.mydemoapp.android

# Get device logs
adb logcat

# Take screenshot
adb shell screencap -p /sdcard/screenshot.png
adb pull /sdcard/screenshot.png

# Get current activity
adb shell dumpsys window windows | grep -E 'mCurrentFocus'
```

### Appium Commands
```bash
# Start Appium with logs
appium --log appium.log

# Start Appium Inspector
appium-inspector
```

### Maven Commands
```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Run specific test
mvn test -Dtest=TestRunner

# Skip tests during build
mvn clean install -DskipTests

# Generate reports
mvn surefire-report:report
```

## Additional Resources

- **Appium Documentation**: https://appium.io/docs/en/latest/
- **Cucumber Java**: https://cucumber.io/docs/cucumber/
- **Selenium Documentation**: https://www.selenium.dev/documentation/
- **My Demo App Repository**: https://github.com/saucelabs/my-demo-app-android

## Support

For issues or questions:
1. Check the Troubleshooting section
2. Review Appium logs
3. Consult the official documentation
4. Open an issue in the project repository

Happy Testing! 🚀

