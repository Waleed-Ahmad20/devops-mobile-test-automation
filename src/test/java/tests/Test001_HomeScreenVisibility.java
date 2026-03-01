package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class Test001_HomeScreenVisibility extends BaseTest {

    @Test(description = "Verify home screen is displayed after app launch")
    public void testHomeScreenVisible() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomeScreenVisible(), 
            "Home screen should be visible with Views menu");
        System.out.println("✓ Test 001 PASSED: Home screen is visible");
    }
}
