package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    @Parameters({"appPackage", "appActivity", "appPath", "hubUrl"})
    public void setUp(
            @Optional("io.appium.android.apis") String appPackage,
            @Optional("io.appium.android.apis.ApiDemos") String appActivity,
            @Optional("") String appPath,
            @Optional("http://127.0.0.1:4723/wd/hub") String hubUrl) throws Exception {
        DriverFactory.initDriver(appPackage, appActivity, appPath, hubUrl);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
