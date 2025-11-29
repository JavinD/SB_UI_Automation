# SB UI Automation - Android App Testing Framework

Mobile UI automation framework for testing the Sauce Labs Demo App on Android using Appium, Cucumber, and Java.

## 📋 Table of Contents
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Test Tags](#test-tags)

---

## 🛠️ Prerequisites

### Required Software

1. **Java JDK 11+**
   - Download: https://www.oracle.com/java/technologies/javase-downloads.html
   - Verify: `java -version`

2. **Node.js 16+**
   - Download: https://nodejs.org/
   - Verify: `node --version`

3. **Maven 3.6+**
   - Download: https://maven.apache.org/download.cgi
   - Verify: `mvn --version`

4. **Appium 2.x**
   ```powershell
   npm install -g appium
   appium --version
   ```

5. **Appium UiAutomator2 Driver**
   ```powershell
   appium driver install uiautomator2
   appium driver list --installed
   ```

6. **Android SDK & Platform Tools**
   - Download Android Studio: https://developer.android.com/studio
   - Or install SDK command-line tools
   - Add to PATH: `ANDROID_HOME` environment variable
   - Verify: `adb --version`

7. **Android Emulator or Physical Device**
   - **Emulator**: Create via Android Studio AVD Manager
   - **Physical Device**: Enable USB Debugging in Developer Options

---

## 🚀 Project Setup

### 1. Clone or Extract Project
```powershell
cd D:\Javin\Job\SB\SB_UI_Automation\SB_UI_Automation
```

### 2. Install Dependencies
```powershell
mvn clean install -DskipTests
```

### 3. Download APK
Place the `MyDemoApp.apk` file in:
```
src/test/resources/app/MyDemoApp.apk
```

Download from: https://github.com/saucelabs/my-demo-app-android/releases

### 4. Start Android Emulator or Device
**For Emulator:**
```powershell
emulator -avd YOUR_AVD_NAME
```

**For Physical Device:**
- Connect via USB
- Enable USB Debugging
- Trust computer connection

### 5. Verify Device Connection
```powershell
adb devices
```
Expected output:
```
List of devices attached
emulator-5554    device
```

### 6. Configure Test Settings
Edit `src/test/resources/config.properties`:

```properties
# Update with your device name from 'adb devices'
deviceName=emulator-5554

# Update with your Android version (check in Settings > About Phone)
platformVersion=14.0

# Valid test credentials
validUsername=bob@example.com
validPassword=10203040
```

### 7. Start Appium Server
```powershell
appium
```
Keep this terminal running. You should see:
```
[Appium] Welcome to Appium v2.x.x
[Appium] Appium REST http interface listener started on http://127.0.0.1:4723
```

---

## ▶️ Running Tests

### Run All Tests
```powershell
mvn test
```

### Run Specific Test Tags
```powershell
# Smoke tests only
mvn test '-Dcucumber.filter.tags=@smoke'

# Login tests
mvn test '-Dcucumber.filter.tags=@login'

# Cart tests
mvn test '-Dcucumber.filter.tags=@cart'

# Complete E2E flow
mvn test '-Dcucumber.filter.tags=@e2e'

# Positive test cases only
mvn test '-Dcucumber.filter.tags=@positive'

# Negative test cases only
mvn test '-Dcucumber.filter.tags=@negative'
```

### Combine Tags
```powershell
# Smoke AND checkout tests
mvn test '-Dcucumber.filter.tags=@smoke and @checkout'

# Login OR cart tests
mvn test '-Dcucumber.filter.tags=@login or @cart'
```

### Skip Clean (Faster)
```powershell
mvn test '-Dcucumber.filter.tags=@smoke'
```

---

## 📁 Project Structure

```
SB_UI_Automation/
├── src/test/
│   ├── java/com/saucedemo/
│   │   ├── config/
│   │   │   └── ConfigReader.java          # Configuration file reader
│   │   ├── driver/
│   │   │   └── DriverManager.java         # Appium driver management
│   │   ├── pages/
│   │   │   ├── general/
│   │   │   │   ├── BasePage.java          # Base page with common methods
│   │   │   │   └── HeaderComponent.java   # Header component (menu, cart)
│   │   │   ├── catalog/
│   │   │   │   ├── CatalogPage.java       # Product catalog page
│   │   │   │   └── SortModal.java         # Sorting modal
│   │   │   ├── productdetail/
│   │   │   │   └── ProductDetailPage.java # Product detail page
│   │   │   ├── cart/
│   │   │   │   └── CartPage.java          # Shopping cart page
│   │   │   ├── login/
│   │   │   │   └── LoginPage.java         # Login page
│   │   │   └── checkout/
│   │   │       ├── ShippingInfoPage.java  # Shipping information
│   │   │       ├── PaymentInfoPage.java   # Payment information
│   │   │       ├── CheckoutInfoPage.java  # Order review
│   │   │       └── CheckoutCompletePage.java # Order confirmation
│   │   ├── steps/                          # Step definitions (mirrors pages/)
│   │   └── runner/
│   │       └── TestRunner.java             # Cucumber test runner
│   └── resources/
│       ├── app/
│       │   └── MyDemoApp.apk               # Android app to test
│       ├── features/                        # Cucumber feature files (mirrors pages/)
│       └── config.properties                # Test configuration
├── pom.xml                                  # Maven dependencies
└── README.md
```

---

## ⚙️ Configuration

### config.properties
Located at: `src/test/resources/config.properties`

```properties
# Appium Server
appiumServerUrl=http://127.0.0.1:4723

# Android Device
platformName=Android
deviceName=emulator-5554
platformVersion=14.0
automationName=UiAutomator2

# Application
appPackage=com.saucelabs.mydemoapp.android
appActivity=com.saucelabs.mydemoapp.android.view.activities.SplashActivity
appPath=src/test/resources/app/MyDemoApp.apk

# App Launch Settings
appWaitActivity=*
appWaitDuration=30

# Wait Times (seconds)
implicitWait=10
explicitWait=20

# Test Credentials
validUsername=bob@example.com
validPassword=10203040
```

### Using Config in Tests
```java
// In feature files, use "from_config" or "config" placeholder
When I enter username "from_config"
And I enter password "from_config"

// Credentials will be automatically loaded from config.properties
```

---

## 🏷️ Test Tags

| Tag | Description | Example |
|-----|-------------|---------|
| `@smoke` | Critical path tests | `mvn test '-Dcucumber.filter.tags=@smoke'` |
| `@e2e` | End-to-end complete flows | `mvn test '-Dcucumber.filter.tags=@e2e'` |
| `@launch` | App launch tests | `mvn test '-Dcucumber.filter.tags=@launch'` |
| `@catalog` | Product catalog tests | `mvn test '-Dcucumber.filter.tags=@catalog'` |
| `@productdetail` | Product detail tests | `mvn test '-Dcucumber.filter.tags=@productdetail'` |
| `@cart` | Shopping cart tests | `mvn test '-Dcucumber.filter.tags=@cart'` |
| `@login` | Login functionality tests | `mvn test '-Dcucumber.filter.tags=@login'` |
| `@checkout` | Checkout process tests | `mvn test '-Dcucumber.filter.tags=@checkout'` |
| `@shippinginfo` | Shipping info tests | `mvn test '-Dcucumber.filter.tags=@shippinginfo'` |
| `@paymentinfo` | Payment info tests | `mvn test '-Dcucumber.filter.tags=@paymentinfo'` |
| `@sort` | Product sorting tests | `mvn test '-Dcucumber.filter.tags=@sort'` |
| `@positive` | Positive test scenarios | `mvn test '-Dcucumber.filter.tags=@positive'` |
| `@negative` | Negative test scenarios | `mvn test '-Dcucumber.filter.tags=@negative'` |

---

## 📊 Test Reports

After test execution, reports are generated in:
```
target/cucumber-reports/cucumber-html-report.html
```

Open in browser to view detailed test results with screenshots and logs.

---

## 🎯 Quick Start Checklist

- [ ] Install Java JDK 11+
- [ ] Install Node.js & Appium
- [ ] Install Appium UiAutomator2 driver
- [ ] Install Android SDK & ADB
- [ ] Start Android emulator or connect device
- [ ] Verify device with `adb devices`
- [ ] Place APK at `src/test/resources/app/MyDemoApp.apk`
- [ ] Update `config.properties` with device name and platform version
- [ ] Start Appium server: `appium`
- [ ] Run tests: `mvn test '-Dcucumber.filter.tags=@smoke'`

---

## 📄 License

This project is for educational and testing purposes.
