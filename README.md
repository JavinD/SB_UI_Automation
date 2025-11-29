# My Demo App - Android UI Automation (Barebones Starter)

A minimal starter framework for Android UI automation using Java, Cucumber, and Appium. Build your own test features on this foundation!

## 🎯 What's Included

This is a **barebones template** with:
- ✅ Complete project setup (Maven, dependencies, configuration)
- ✅ Driver management for Appium
- ✅ Base page object with common methods
- ✅ Cucumber integration (hooks, runner)
- ✅ Sample templates for pages, steps, and features
- ❌ No pre-built test scenarios (you design them!)

## 🚀 Quick Start

### 1. Install Prerequisites
```bash
# Java JDK 11+
java -version

# Maven
mvn -version

# Appium
npm install -g appium@next
appium driver install uiautomator2
```

### 2. Get the APK
Download from: https://github.com/saucelabs/my-demo-app-android/releases  
Place in: `src/test/resources/app/MyDemoApp.apk`

### 3. Configure
Edit `src/test/resources/config.properties`:
```properties
deviceName=YOUR_DEVICE_NAME  # From 'adb devices'
platformVersion=12.0         # Your Android version
```

### 4. Install Dependencies
```bash
mvn clean install -DskipTests
```

### 5. Run
```bash
# Terminal 1: Start Appium
appium

# Terminal 2: Run tests
mvn clean test
```

## 📁 Project Structure

```
├── src/test/java/com/saucedemo/
│   ├── config/
│   │   └── ConfigReader.java         # Configuration management
│   ├── driver/
│   │   └── DriverManager.java        # Appium driver lifecycle
│   ├── pages/
│   │   ├── BasePage.java             # Common page methods
│   │   └── SamplePage.java           # Template for your pages
│   ├── steps/
│   │   ├── Hooks.java                # Before/After scenario
│   │   └── SampleSteps.java          # Template for step definitions
│   └── runners/
│       └── TestRunner.java           # Cucumber test runner
├── src/test/resources/
│   ├── features/
│   │   └── Sample.feature            # Template feature file
│   ├── app/
│   │   └── MyDemoApp.apk             # Your APK
│   └── config.properties             # Settings
└── pom.xml                           # Maven dependencies
```

## 🔨 Building Your Tests

### Step 1: Find Element Locators
Use Appium Inspector to identify elements:
```bash
npm install -g appium-inspector
```

### Step 2: Create Page Object
Create `src/test/java/com/saucedemo/pages/YourPage.java`:
```java
public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "username")
    private WebElement usernameField;
    
    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }
}
```

### Step 3: Write Feature File
Create `src/test/resources/features/YourFeature.feature`:
```gherkin
Feature: Login
  @login
  Scenario: User logs in
    Given the app is launched
    When I enter credentials
    Then I should see home page
```

### Step 4: Implement Steps
Create `src/test/java/com/saucedemo/steps/YourSteps.java`:
```java
public class LoginSteps {
    @When("I enter credentials")
    public void iEnterCredentials() {
        // Your implementation
    }
}
```

### Step 5: Run Your Tests
```bash
mvn clean test
```

## 📚 Documentation

- **[QUICK_START.md](QUICK_START.md)** - Quick reference guide
- **[SETUP_GUIDE.md](SETUP_GUIDE.md)** - Complete setup instructions

## 💡 Common Locator Strategies

```java
// Accessibility ID
@AndroidFindBy(accessibility = "button-name")

// Resource ID
@AndroidFindBy(id = "com.app:id/element_id")

// UiAutomator
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")

// XPath
@AndroidFindBy(xpath = "//android.widget.Button[@text='Click']")
```

## 🛠️ Useful Commands

```bash
# Check devices
adb devices

# Get current activity
adb shell dumpsys window windows | grep -E 'mCurrentFocus'

# Install APK
adb install -r path/to/app.apk

# Run specific tag
mvn test -Dcucumber.filter.tags="@smoke"
```

## 📊 Test Reports

After execution, view reports:
- **HTML Report**: `target/cucumber-reports/cucumber.html`
- **Screenshots**: `target/screenshots/` (on failure)

## 🎓 Resources

- [Appium Docs](https://appium.io/docs/en/latest/)
- [Cucumber Docs](https://cucumber.io/docs/cucumber/)
- [My Demo App](https://github.com/saucelabs/my-demo-app-android)

## 🏗️ Design Your Features

This is a **starter template**. You need to:
1. 📱 Use Appium Inspector to find element locators
2. 📄 Create page objects for app screens
3. 📝 Write feature files with your scenarios
4. 🔧 Implement step definitions
5. ▶️ Run and iterate!

---

**Start building!** Check out the sample files and templates to get started. 🚀
