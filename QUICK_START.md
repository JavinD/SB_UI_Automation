# Quick Start Guide - Barebones Version

This is a minimal starter framework for Android UI automation. Build your own features on top of this foundation!

## What's Included

### Core Structure ✅
- **Maven Project** (`pom.xml`) - All dependencies configured
- **Driver Management** (`DriverManager.java`) - Handles Appium driver lifecycle
- **Configuration** (`config.properties`) - Centralized settings
- **Base Page** (`BasePage.java`) - Common page object methods
- **Hooks** (`Hooks.java`) - Before/After scenario setup
- **Test Runner** (`TestRunner.java`) - Cucumber test execution

### Templates 📝
- **SamplePage.java** - Template for creating page objects
- **SampleSteps.java** - Template for step definitions
- **Sample.feature** - Template for feature files

## Essential Setup

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

### 2. Set Environment Variables
```bash
# Windows
setx JAVA_HOME "C:\Program Files\Java\jdk-11.0.x"
setx ANDROID_HOME "C:\Users\YourUsername\AppData\Local\Android\Sdk"

# Mac/Linux
export JAVA_HOME=/path/to/jdk
export ANDROID_HOME=/path/to/android-sdk
```

### 3. Get the APK
Download from: https://github.com/saucelabs/my-demo-app-android/releases
Place in: `src/test/resources/app/MyDemoApp.apk`

### 4. Configure
Edit `src/test/resources/config.properties`:
```properties
deviceName=YOUR_DEVICE_NAME  # From 'adb devices'
platformVersion=YOUR_ANDROID_VERSION  # e.g., 12.0
```

### 5. Run
```bash
# Terminal 1: Start Appium
appium

# Terminal 2: Run tests
mvn clean test
```

## Building Your Tests

### Creating a New Page Object

1. Create a new class in `src/test/java/com/saucedemo/pages/`
2. Extend `BasePage`
3. Add element locators using `@AndroidFindBy`
4. Add methods to interact with elements

**Example:**
```java
package com.saucedemo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    
    @AndroidFindBy(accessibility = "username-input")
    private WebElement usernameField;
    
    @AndroidFindBy(accessibility = "password-input")
    private WebElement passwordField;
    
    @AndroidFindBy(accessibility = "login-button")
    private WebElement loginButton;
    
    public void login(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(loginButton);
    }
}
```

### Creating a New Feature File

1. Create a `.feature` file in `src/test/resources/features/`
2. Write scenarios in Gherkin syntax

**Example:**
```gherkin
Feature: User Login
  
  @login
  Scenario: Successful login
    Given the app is launched
    When I login with username "user@example.com" and password "password123"
    Then I should see the home page
```

### Creating Step Definitions

1. Create a class in `src/test/java/com/saucedemo/steps/`
2. Add methods with `@Given`, `@When`, `@Then` annotations

**Example:**
```java
package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {
    
    private LoginPage loginPage;
    
    @When("I login with username {string} and password {string}")
    public void iLoginWith(String username, String password) {
        loginPage = new LoginPage();
        loginPage.login(username, password);
    }
    
    @Then("I should see the home page")
    public void iShouldSeeHomePage() {
        // Add your assertion
    }
}
```

## Finding Element Locators

### Using Appium Inspector

1. Install: `npm install -g appium-inspector`
2. Start Appium server
3. Start Appium Inspector
4. Connect with your device capabilities
5. Inspect elements and copy locators

### Common Locator Strategies

```java
// By Accessibility ID
@AndroidFindBy(accessibility = "accessibility-id")

// By Resource ID
@AndroidFindBy(id = "com.package.name:id/element_id")

// By UiAutomator
@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"id\")")
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Button Text\")")

// By XPath
@AndroidFindBy(xpath = "//android.widget.Button[@text='Click Me']")

// By Class Name
@AndroidFindBy(className = "android.widget.Button")
```

## Project Structure

```
SB_UI_Automation/
├── src/test/java/com/saucedemo/
│   ├── config/
│   │   └── ConfigReader.java          # Read configuration
│   ├── driver/
│   │   └── DriverManager.java         # Manage Appium driver
│   ├── pages/
│   │   ├── BasePage.java              # Base class with common methods
│   │   └── SamplePage.java            # Template for new pages
│   ├── steps/
│   │   ├── Hooks.java                 # Before/After scenario setup
│   │   └── SampleSteps.java           # Template for step definitions
│   └── runners/
│       └── TestRunner.java            # Run Cucumber tests
├── src/test/resources/
│   ├── features/
│   │   └── Sample.feature             # Template feature file
│   ├── app/
│   │   └── MyDemoApp.apk              # Your APK file
│   └── config.properties              # Configuration settings
└── pom.xml                            # Maven dependencies
```

## Useful Commands

```bash
# Check connected devices
adb devices

# Install APK manually
adb install -r path/to/app.apk

# Get current activity
adb shell dumpsys window windows | grep -E 'mCurrentFocus'

# View logs
adb logcat

# Run specific test tag
mvn test -Dcucumber.filter.tags="@login"

# Run specific feature
mvn test -Dcucumber.features="src/test/resources/features/Login.feature"
```

## Next Steps

1. ✅ Complete the essential setup above
2. 📱 Use Appium Inspector to find element locators
3. 📄 Create your first page object
4. 📝 Write your first feature file
5. 🔧 Implement step definitions
6. ▶️ Run and iterate!

## Tips

- **Start Small**: Create one page object and one scenario first
- **Use Appium Inspector**: Essential for finding element locators
- **Test Incrementally**: Run tests frequently as you build
- **Check Logs**: Look at Appium server logs for debugging
- **Take Screenshots**: Already configured in Hooks on test failure

## Full Documentation

For complete setup instructions including troubleshooting, see:
- **SETUP_GUIDE.md** - Comprehensive installation guide

## Resources

- [Appium Documentation](https://appium.io/docs/en/latest/)
- [Cucumber Documentation](https://cucumber.io/docs/cucumber/)
- [My Demo App Source](https://github.com/saucelabs/my-demo-app-android)

---

**Ready to build!** Start by creating your first page object and feature file. 🚀

