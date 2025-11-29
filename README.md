# SB UI Automation

Android UI automation testing framework using Appium, Cucumber, and Java.

**Demo Video:** [View Test Execution](https://drive.google.com/file/d/1GNXdx6SdeN415ukVGEKR8ACWuc99qSEe/view?usp=drive_link)

## Prerequisites

- Java JDK 11+
- Node.js 16+
- Maven 3.6+
- Appium 2.x: `npm install -g appium`
- UiAutomator2 Driver: `appium driver install uiautomator2`
- Android SDK with ADB
- Android Emulator or Physical Device

## Setup

1. Install dependencies:
```powershell
mvn clean install -DskipTests
```

2. Download [MyDemoApp.apk](https://github.com/saucelabs/my-demo-app-android/releases) to `src/test/resources/app/`

3. Update `src/test/resources/config.properties`:
```properties
deviceName=emulator-5554
platformVersion=14.0
validUsername=bob@example.com
validPassword=10203040
```

4. Start device: `adb devices`

5. Start Appium: `appium`

## Running Tests

Run all tests:
```powershell
mvn test
```

Run by tags:
```powershell
mvn test '-Dcucumber.filter.tags=@smoke'
mvn test '-Dcucumber.filter.tags=@login'
mvn test '-Dcucumber.filter.tags=@cart'
mvn test '-Dcucumber.filter.tags=@e2e'
```

Combine tags:
```powershell
mvn test '-Dcucumber.filter.tags=@smoke and @checkout'
mvn test '-Dcucumber.filter.tags=@login or @cart'
```

## Test Tags

| Tag | Description |
|-----|-------------|
| `@smoke` | Critical path tests |
| `@e2e` | End-to-end flows |
| `@launch` | App launch |
| `@catalog` | Product catalog |
| `@productdetail` | Product details |
| `@cart` | Shopping cart |
| `@login` | Login functionality |
| `@checkout` | Checkout process |
| `@sort` | Product sorting |
| `@positive` | Positive scenarios |
| `@negative` | Negative scenarios |

## Reports

Test reports: `target/cucumber-reports/cucumber-html-report.html`
