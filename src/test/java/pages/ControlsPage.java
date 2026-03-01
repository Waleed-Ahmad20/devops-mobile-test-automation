package pages;

import base.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ControlsPage {
    private AndroidDriver driver = DriverFactory.getDriver();

    private By lightCheckbox = By.xpath("//android.widget.CheckBox[1]");
    private By checkboxText = By.xpath("//android.widget.CheckBox[1]/following-sibling::android.widget.TextView");
    private By toggleButton = By.xpath("//android.widget.ToggleButton[1]");
    private By radioButton1 = By.xpath("//android.widget.RadioButton[1]");

    public boolean isControlsPageLoaded() {
        return !driver.findElements(lightCheckbox).isEmpty();
    }

    public boolean isCheckboxChecked() {
        WebElement checkbox = driver.findElement(lightCheckbox);
        return checkbox.getAttribute("checked").equals("true");
    }

    public void toggleCheckbox() {
        WebElement checkbox = driver.findElement(lightCheckbox);
        checkbox.click();
        System.out.println("✓ Toggled checkbox");
    }

    public String getCheckboxLabel() {
        return driver.findElement(checkboxText).getText();
    }

    public void clickToggleButton() {
        WebElement toggle = driver.findElement(toggleButton);
        toggle.click();
        System.out.println("✓ Clicked toggle button");
    }

    public void selectRadioButton() {
        WebElement radio = driver.findElement(radioButton1);
        radio.click();
        System.out.println("✓ Selected radio button");
    }

    public boolean isToggleButtonOn() {
        WebElement toggle = driver.findElement(toggleButton);
        return toggle.getText().equalsIgnoreCase("ON");
    }

    public boolean isRadioButtonSelected() {
        WebElement radio = driver.findElement(radioButton1);
        return radio.getAttribute("checked").equals("true");
    }

    public int getCheckboxCount() {
        return driver.findElements(By.xpath("//android.widget.CheckBox")).size();
    }
}
