package pages;

import base.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private AndroidDriver driver = DriverFactory.getDriver();

    private By viewsMenu = By.xpath("//android.widget.TextView[@content-desc='Views']");
    private By animationMenu = By.xpath("//android.widget.TextView[@content-desc='Animation']");
    private By controlsMenu = By.xpath("//android.widget.TextView[@content-desc='Controls']");

    public boolean isHomeScreenVisible() {
        return !driver.findElements(viewsMenu).isEmpty();
    }

    public void openViews() {
        WebElement element = driver.findElement(viewsMenu);
        element.click();
        System.out.println("✓ Opened Views menu");
    }

    public void openAnimation() {
        WebElement element = driver.findElement(animationMenu);
        element.click();
        System.out.println("✓ Opened Animation menu");
    }

    public void openControls() {
        WebElement element = driver.findElement(controlsMenu);
        element.click();
        System.out.println("✓ Opened Controls menu");
    }

    public String getHomeScreenTitle() {
        return driver.findElement(By.id("android:id/action_bar_title")).getText();
    }
}
