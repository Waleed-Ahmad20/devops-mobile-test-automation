package base;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    @Parameters({"appPackage", "appActivity", "appPath", "hubUrl"})
    public void setUp(
            @Optional("io.appium.android.apis") String appPackage,
            @Optional("io.appium.android.apis.ApiDemos") String appActivity,
            @Optional("") String appPath,
            @Optional("http://127.0.0.1:4723/wd/hub") String hubUrl) throws Exception {
        try {
            DriverFactory.initDriver(appPackage, appActivity, appPath, hubUrl);
        } catch (Exception e) {
            throw new SkipException("Appium server not available, skipping tests: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File screenshot = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
                String screenshotDir = "target/surefire-reports/screenshots/";
                Files.createDirectories(Paths.get(screenshotDir));
                Files.copy(screenshot.toPath(),
                        Paths.get(screenshotDir, result.getName() + ".png"),
                        StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✓ Screenshot saved: " + screenshotDir + result.getName() + ".png");
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

