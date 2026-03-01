package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewsPage;

public class Test008_ViewsMenuItems extends BaseTest {

    @Test(description = "Verify Views page contains multiple menu items")
    public void testViewsMenuItems() {
        HomePage homePage = new HomePage();
        homePage.openViews();

        ViewsPage viewsPage = new ViewsPage();
        int menuItemCount = viewsPage.getMenuItemCount();

        Assert.assertTrue(menuItemCount > 0,
            "Views page should have at least one menu item");
        System.out.println("✓ Test 008 PASSED: Found " + menuItemCount + " menu items");
    }
}
