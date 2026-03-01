package pages;

import base.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class TextInputPage {
    private AndroidDriver driver = DriverFactory.getDriver();

    private By editTextInput = By.xpath("//android.widget.EditText[1]");
    private By submitButton = By.xpath("//android.widget.Button[contains(@text, 'Submit')]");

    public boolean isTextInputPageLoaded() {
        return !driver.findElements(editTextInput).isEmpty();
    }

    public void enterText(String text) {
        WebElement inputField = driver.findElement(editTextInput);
        inputField.clear();
        inputField.sendKeys(text);
        System.out.println("✓ Entered text: " + text);
    }

    public String getInputText() {
        return driver.findElement(editTextInput).getText();
    }

    public String getInputValue() {
        return driver.findElement(editTextInput).getAttribute("text");
    }

    public void clearInput() {
        WebElement inputField = driver.findElement(editTextInput);
        inputField.clear();
        System.out.println("✓ Cleared input field");
    }

    public int getEditTextCount() {
        return driver.findElements(By.xpath("//android.widget.EditText")).size();
    }
}
