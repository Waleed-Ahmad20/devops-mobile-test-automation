# Mobile Test Automation - Appium + TestNG + Java

![CI](https://github.com/Waleed-Ahmad20/devops-mobile-test-automation/actions/workflows/ci.yml/badge.svg)

A professional, minimal-effort Page Object Model (POM) based mobile test automation framework using **Appium**, **TestNG**, and **Java**. This project automates testing of the **Appium ApiDemos** Android app with **10 independent functional tests** following industry best practices.

---

## 📋 Project Overview

- **Framework:** Appium Java Client + TestNG + Maven
- **Target App:** Appium ApiDemos (freely available Android demo app)
- **Tests:** 10 independent, data-driven, and reusable test cases
- **Architecture:** Page Object Model (POM) for maintainability
- **CI/CD:** GitHub Actions pipeline with branch protection and PR reviews
- **Collaboration:** Private GitHub repo with team members

---

## 🏗️ Project Structure

```
mobile-test-automation/
├── pom.xml                          # Maven configuration with dependencies
├── README.md                         # This file
├── .github/
│   └── workflows/
│       └── ci.yml                   # GitHub Actions CI pipeline
├── src/
│   ├── main/
│   │   └── java/                    # Utility classes (if needed)
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   ├── DriverFactory.java          # AndroidDriver initialization
│       │   │   └── BaseTest.java               # Base TestNG class
│       │   ├── pages/
│       │   │   ├── HomePage.java               # Home screen page object
│       │   │   ├── ViewsPage.java              # Views menu page object
│       │   │   ├── ControlsPage.java           # Controls menu page object
│       │   │   └── TextInputPage.java          # Text input page object
│       │   └── tests/
│       │       ├── Test001_HomeScreenVisibility.java
│       │       ├── Test002_NavigateToViews.java
│       │       ├── Test003_NavigateToControls.java
│       │       ├── Test004_CheckboxToggle.java
│       │       ├── Test005_MultipleCheckboxes.java
│       │       ├── Test006_ToggleButtonClick.java
│       │       ├── Test007_RadioButtonSelection.java
│       │       ├── Test008_ViewsMenuItems.java
│       │       ├── Test009_NavigateToAnimation.java
│       │       └── Test010_BackNavigation.java
│       └── resources/
│           └── testng.xml            # TestNG suite configuration
└── docs/
    └── screenshots/                 # Test execution screenshots
```

---

## 🧪 Test Cases

All 10 tests are **independent** and use **assertions** to verify functionality:

| # | Test Name | Description |
|---|-----------|-------------|
| 1 | Home Screen Visibility | Verify app launches and home screen is visible |
| 2 | Navigate to Views | Open Views menu and verify page loads |
| 3 | Navigate to Controls | Open Controls menu and verify page loads |
| 4 | Checkbox Toggle | Toggle a checkbox and verify state change |
| 5 | Multiple Checkboxes | Verify multiple checkboxes exist on Controls page |
| 6 | Toggle Button Click | Click toggle button and verify interaction |
| 7 | Radio Button Selection | Select radio button and verify interaction |
| 8 | Views Menu Items | Verify Views page contains multiple menu items |
| 9 | Navigate to Animation | Open Animation menu from home screen |
| 10 | Back Navigation | Navigate to Views and back to home successfully |

---

## ⚙️ Tech Stack

| Component | Version |
|-----------|---------|
| **Java** | 11 |
| **Maven** | 3.6+ |
| **Appium Java Client** | 8.4.0 |
| **TestNG** | 7.8.0 |
| **Selenium** | 4.11.0 |

---

## 📦 Prerequisites

### Required
- **Java 11 or higher** installed
- **Maven 3.6+** installed
- **Git** for version control
- **Node.js & npm** (for Appium server)

### Optional (for local testing)
- **Android SDK** (Android Emulator or physical device)
- **Appium Server** (for running tests locally)

### Quick Install (Local Setup)

```bash
# Install Appium globally
npm install -g appium

# Install Android drivers for Appium
appium driver install uiautomator2

# Verify installation
appium --version
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Waleed-Ahmad20/devops-mobile-test-automation.git
cd mobile-test-automation
```

### 2. Build the Project

```bash
mvn clean package -DskipTests
```

### 3. Download ApiDemos APK (Optional - for local testing)

If running tests locally, download the ApiDemos APK:

```bash
# Clone the ApiDemos repo
git clone https://github.com/appium/android-apidemos.git

# Build the APK (requires Android SDK)
cd android-apidemos
./gradlew assembleDebug

# APK will be at: android-apidemos/app/build/outputs/apk/debug/app-debug.apk
```

Or use this pre-built APK URL:
```
https://github.com/appium/android-apidemos/releases/download/v0.8.0/ApiDemos-debug.apk
```

---

## 🏃 Running Tests

### Option 1: Run via Maven (Compilation Check Only)

```bash
# Build and compile only (no Appium/device needed for CI)
mvn clean compile

# Run all tests (requires Appium server + device/emulator)
mvn test
```

### Option 2: Run via TestNG XML

```bash
# Run tests specified in testng.xml
mvn test -Dtest=tests.Test*
```

### Option 3: Run Specific Test Class

```bash
# Run a single test
mvn test -Dtest=tests.Test001_HomeScreenVisibility
```

---

## 🔧 Local Testing Setup (For Manual Runs)

### Prerequisites
1. Android Emulator running or device connected
2. Appium server running

### Steps

**Terminal 1: Start Appium Server**

```bash
appium --port 4723 --log-level warn
```

**Terminal 2: Run Tests**

```bash
# Update testng.xml with your device name if needed
mvn test
```

#### Example testng.xml Configuration

```xml
<parameter name="appPackage" value="io.appium.android.apis"/>
<parameter name="appActivity" value="io.appium.android.apis.ApiDemos"/>
<parameter name="appPath" value=""/>
<parameter name="hubUrl" value="http://127.0.0.1:4723/wd/hub"/>
```

---

## 🔄 Git Workflow & Branch Protection

This project enforces professional Git practices:

### Branch Protection Rules
- All commits must be on **feature branches** (not `main`)
- PRs require **at least 1 approval** before merge
- **Status checks** (CI pipeline) must pass
- No direct pushes to `main`

### Feature Branch Workflow

```bash
# Create feature branch
git checkout -b feature/your-feature-name

# Make changes and commit
git add .
git commit -m "feat: add description"

# Push to remote
git push origin feature/your-feature-name

# Open PR on GitHub and wait for approval
```

### Commit Message Convention
```
feat: Add new feature
fix: Fix a bug
chore: Update dependencies
docs: Update documentation
test: Add test cases
```

---

## 🤖 GitHub Actions CI Pipeline

The project includes automated CI using **GitHub Actions**:

### Triggered On
- ✅ Push to `main` branch
- ✅ Push to `feature/**` branches
- ✅ Pull requests to `main`

### Pipeline Stages

1. **Build**: Compile Maven project
2. **Unit Tests**: Run test suite (compilation-based in CI)
3. **Code Quality**: Checkstyle validation
4. **Reports**: Generate test results

### View CI Status
- Navigate to **Actions** tab in GitHub repo
- Click on any workflow run to see logs
- Check PR status check before merging

---

## 📝 Page Object Model (POM) Architecture

The framework uses **Page Object Model** for maintainability:

### Base Classes

**DriverFactory.java**
- Manages AndroidDriver initialization
- Configures desired capabilities
- Handles driver lifecycle (init, quit)

**BaseTest.java**
- Extends all test classes
- Handles @BeforeClass and @AfterClass
- Initializes/closes driver for each test

### Page Objects

Each page object represents a screen in the app:

```java
public class HomePage {
    private AndroidDriver driver = DriverFactory.getDriver();
    private By viewsMenu = By.xpath("...");  // Locators
    
    public void openViews() { ... }          // Actions
    public boolean isHomeScreenVisible() { ... }  // Verifications
}
```

**Benefits:**
- Easy to maintain: change locator in one place
- Reusable: multiple tests can use same page object
- Readable: test code is clear and descriptive
- Scalable: add new pages without modifying tests

---

## 📊 Test Execution Evidence

### Local Test Run
To capture evidence of successful test runs:

```bash
# Run tests
mvn test

# Appium automatically saves screenshots to target/surefire-reports/
```

### Screenshots Location
- **After Test Run:** `target/surefire-reports/` (if configured)
- **Manual Capture:** Use Appium Inspector or `driver.getScreenshotAs(OutputType.FILE)`

---

## 🔒 GitHub Repository Setup

### Repo Configuration (Already Done)
- ✅ Private repository
- ✅ Branch protection on `main`
- ✅ Collaborators added
- ✅ GitHub Issues enabled
- ✅ CI workflow configured

### Accessing the Repo
```
https://github.com/Waleed-Ahmad20/devops-mobile-test-automation
```

---

## 🧩 Adding New Tests

To add a new test case:

1. **Create a new test class** in `src/test/java/tests/`

```java
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class Test011_NewTest extends BaseTest {
    @Test(description = "Test description")
    public void testNewFeature() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomeScreenVisible());
        System.out.println("✓ Test passed");
    }
}
```

2. **Add to testng.xml**

```xml
<test name="New Tests">
    <classes>
        <class name="tests.Test011_NewTest"/>
    </classes>
</test>
```

3. **Commit and push** via feature branch + PR

---

## 🐛 Troubleshooting

### Issue: "Driver is not initialized"
**Solution:** Ensure DriverFactory.initDriver() is called before tests. Check @BeforeClass in BaseTest.

### Issue: "Element not found"
**Solution:** Verify locator using Appium Inspector. Update locator in page object.

### Issue: "Connection refused" (Appium server)
**Solution:** 
```bash
# Make sure Appium server is running
appium --port 4723
```

### Issue: "ANDROID_HOME not set"
**Solution:**
```bash
# Linux/Mac
export ANDROID_HOME=~/Library/Android/sdk

# Windows
set ANDROID_HOME=C:\Users\[YourUsername]\AppData\Local\Android\sdk
```

---

## 📚 Resources

- [Appium Official Docs](https://appium.io/docs/)
- [Appium Java Client GitHub](https://github.com/appium/java-client)
- [TestNG Documentation](https://testng.org/)
- [Page Object Model Best Practices](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
- [ApiDemos GitHub](https://github.com/appium/android-apidemos)

---

## 👥 Team

- **Project Lead:** [Your Name]
- **QA Engineer:** [Team Member Name]
- **Repository:** Private GitHub repo (branch-protected)

---

## 📄 License

This project is for educational purposes as part of a DevOps/QA automation assignment.

---

## ✅ Checklist for Submission

- [x] Private GitHub repo with collaborators
- [x] Branch protection and PR reviews enabled
- [x] 10 independent TestNG tests implemented
- [x] Page Object Model architecture used
- [x] GitHub Actions CI pipeline configured
- [x] Maven project with proper pom.xml
- [x] testng.xml test suite configuration
- [x] Comprehensive README with setup instructions
- [ ] Screenshots of successful test runs (add to docs/screenshots/)
- [x] CI badge added to repo

---

## 🎯 Quick Reference

| Task | Command |
|------|---------|
| Clone repo | `git clone [repo-url]` |
| Build project | `mvn clean package` |
| Run all tests | `mvn test` |
| Run single test | `mvn test -Dtest=Test001*` |
| Compile only | `mvn clean compile` |
| Create feature branch | `git checkout -b feature/name` |
| Push changes | `git push origin feature/name` |
| View CI logs | GitHub → Actions tab |

---

**For questions or issues, refer to the GitHub Issues page or contact your team lead.**
