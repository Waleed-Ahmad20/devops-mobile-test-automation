package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class Test009_NavigateToAnimation extends BaseTest {

    @Test(description = "Navigate to Animation menu and verify navigation")
    public void testNavigateToAnimation() {
        HomePage homePage = new HomePage();
        
        Assert.assertTrue(homePage.isHomeScreenVisible(), 
            "Home screen should be visible initially");
        
        homePage.openAnimation();
        Assert.assertFalse(homePage.isHomeScreenVisible(), 
            "Home screen should no longer be visible after navigating to Animation");
        System.out.println("✓ Test 009 PASSED: Successfully navigated away from home to Animation");
    }
}
