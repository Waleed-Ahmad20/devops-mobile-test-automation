package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static AndroidDriver driver;

    public static void initDriver(String appPackage, String appActivity, String appPath, String hubUrl)
            throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator-5554")
                .setNewCommandTimeout(Duration.ofSeconds(60));

        if (appPath != null && !appPath.isEmpty()) {
            options.setApp(appPath);
        } else {
            options.setAppPackage(appPackage);
            options.setAppActivity(appActivity);
        }

        driver = new AndroidDriver(new URL(hubUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✓ AndroidDriver initialized successfully");
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("✓ AndroidDriver quit successfully");
        }
    }
}
