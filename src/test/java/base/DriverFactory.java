package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static AndroidDriver driver;

    public static void initDriver(String appPackage, String appActivity, String appPath, String hubUrl)
            throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

        if (appPath != null && !appPath.isEmpty()) {
            caps.setCapability(MobileCapabilityType.APP, appPath);
        } else {
            caps.setCapability(MobileCapabilityType.APP_PACKAGE, appPackage);
            caps.setCapability(MobileCapabilityType.APP_ACTIVITY, appActivity);
        }

        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

        driver = new AndroidDriver(new URL(hubUrl), caps);
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
