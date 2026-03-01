package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewsPage;

public class Test010_BackNavigation extends BaseTest {

    @Test(description = "Navigate to Views and then back to home screen")
    public void testBackNavigation() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isHomeScreenVisible(), 
            "Home screen should be visible initially");
        
        homePage.openViews();
        
        ViewsPage viewsPage = new ViewsPage();
        Assert.assertTrue(viewsPage.isViewsPageLoaded(), 
            "Views page should be loaded");
        
        viewsPage.goBack();
        
        HomePage homePageAfterBack = new HomePage();
        Assert.assertTrue(homePageAfterBack.isHomeScreenVisible(), 
            "Should return to home screen after back navigation");
        System.out.println("✓ Test 010 PASSED: Back navigation successful");
    }
}
