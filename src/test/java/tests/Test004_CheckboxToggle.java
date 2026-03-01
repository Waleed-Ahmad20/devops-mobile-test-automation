package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ControlsPage;

public class Test004_CheckboxToggle extends BaseTest {

    @Test(description = "Toggle checkbox and verify state change")
    public void testCheckboxToggle() {
        HomePage homePage = new HomePage();
        homePage.openControls();

        ControlsPage controlsPage = new ControlsPage();
        boolean initialState = controlsPage.isCheckboxChecked();

        controlsPage.toggleCheckbox();
        boolean newState = controlsPage.isCheckboxChecked();

        Assert.assertNotEquals(initialState, newState,
            "Checkbox state should change after toggle");
        System.out.println("✓ Test 004 PASSED: Checkbox toggled successfully");
    }
}
