package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ControlsPage;

public class Test003_NavigateToControls extends BaseTest {

    @Test(description = "Navigate to Controls menu and verify page loads")
    public void testNavigateToControls() {
        HomePage homePage = new HomePage();
        homePage.openControls();
        
        ControlsPage controlsPage = new ControlsPage();
        Assert.assertTrue(controlsPage.isControlsPageLoaded(), 
            "Controls page should be loaded with checkboxes");
        System.out.println("✓ Test 003 PASSED: Successfully navigated to Controls");
    }
}
