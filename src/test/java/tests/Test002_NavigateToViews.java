package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewsPage;

public class Test002_NavigateToViews extends BaseTest {

    @Test(description = "Navigate to Views menu and verify page loads")
    public void testNavigateToViews() {
        HomePage homePage = new HomePage();
        homePage.openViews();

        ViewsPage viewsPage = new ViewsPage();
        Assert.assertTrue(viewsPage.isViewsPageLoaded(),
            "Views page should be loaded with menu items");
        System.out.println("✓ Test 002 PASSED: Successfully navigated to Views");
    }
}
