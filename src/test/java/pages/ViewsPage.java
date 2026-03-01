package pages;

import base.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewsPage {
    private AndroidDriver driver = DriverFactory.getDriver();

    private By alertsMenu = By.xpath("//android.widget.TextView[@content-desc='Alerts']");
    private By expandableListMenu = By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']");
    private By datePickerMenu = By.xpath("//android.widget.TextView[@content-desc='Date Widgets']");
    private By backButton = By.id("android:id/action_bar_up");

    public boolean isViewsPageLoaded() {
        return !driver.findElements(alertsMenu).isEmpty();
    }

    public void openAlerts() {
        WebElement element = driver.findElement(alertsMenu);
        element.click();
        System.out.println("✓ Opened Alerts");
    }

    public void openExpandableLists() {
        WebElement element = driver.findElement(expandableListMenu);
        element.click();
        System.out.println("✓ Opened Expandable Lists");
    }

    public void openDateWidgets() {
        WebElement element = driver.findElement(datePickerMenu);
        element.click();
        System.out.println("✓ Opened Date Widgets");
    }

    public int getMenuItemCount() {
        return driver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).size();
    }

    public void goBack() {
        driver.navigate().back();
        System.out.println("✓ Navigated back");
    }
}
