package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ControlsPage;

public class Test005_MultipleCheckboxes extends BaseTest {

    @Test(description = "Verify multiple checkboxes are present on Controls page")
    public void testMultipleCheckboxes() {
        HomePage homePage = new HomePage();
        homePage.openControls();
        
        ControlsPage controlsPage = new ControlsPage();
        int checkboxCount = controlsPage.getCheckboxCount();
        
        Assert.assertGreaterThan(checkboxCount, 0, 
            "At least one checkbox should be present");
        System.out.println("✓ Test 005 PASSED: Found " + checkboxCount + " checkboxes");
    }
}
