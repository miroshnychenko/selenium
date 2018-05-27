package tomascook;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.tomascook.HomePage;

@Listeners({selenium.core.TestListener.class})
public class HomePageTest extends WebDriverTestBase{

    @Test
    public void homePageTest(){
        driver.get("https://www.thomascook.com/");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(home.isLogoPresent());
        Assert.assertTrue(home.isTopNavigationBarPresent());
        Assert.assertTrue(home.isSearchBarPresent());
        Assert.assertTrue(home.isFooterPresent());
    }
}
