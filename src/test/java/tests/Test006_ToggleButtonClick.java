package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ControlsPage;

public class Test006_ToggleButtonClick extends BaseTest {

    @Test(description = "Click toggle button and verify state changes")
    public void testToggleButtonClick() {
        HomePage homePage = new HomePage();
        homePage.openControls();
        
        ControlsPage controlsPage = new ControlsPage();
        boolean stateBefore = controlsPage.isToggleButtonOn();
        controlsPage.clickToggleButton();
        boolean stateAfter = controlsPage.isToggleButtonOn();
        
        Assert.assertNotEquals(stateAfter, stateBefore, 
            "Toggle button state should change after clicking");
        System.out.println("✓ Test 006 PASSED: Toggle button state changed from " + stateBefore + " to " + stateAfter);
    }
}
