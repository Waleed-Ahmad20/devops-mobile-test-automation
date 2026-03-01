package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ControlsPage;

public class Test007_RadioButtonSelection extends BaseTest {

    @Test(description = "Select radio button and verify it is selected")
    public void testRadioButtonSelection() {
        HomePage homePage = new HomePage();
        homePage.openControls();

        ControlsPage controlsPage = new ControlsPage();
        controlsPage.selectRadioButton();

        Assert.assertTrue(controlsPage.isRadioButtonSelected(),
            "Radio button should be selected after clicking");
        System.out.println("✓ Test 007 PASSED: Radio button selected and verified");
    }
}
