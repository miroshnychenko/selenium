package ua.com.stylus;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.PropertiesCache;
import selenium.core.WebDriverTestBase;
import selenium.pages.stylus.MainPage;
import selenium.pages.stylus.ProductDetailsPage;
import selenium.pages.stylus.SearchPage;

import java.io.UnsupportedEncodingException;

public class StylusTest extends WebDriverTestBase {
    private String searchQuery = String.valueOf(PropertiesCache.getProperty("stylus.searchQuery"));
    private String searchUrl = searchQuery.replace(" ", "+");

    @Test
    public void StylusSearchTest() throws UnsupportedEncodingException{
        String expectedProductTitle = String.valueOf(PropertiesCache.getProperty("stylus.expectedProductTitle")
                .getBytes("ISO8859-1"));
        driver.get("https://stylus.com.ua");
        MainPage mainPage = new MainPage(driver);
        mainPage.search(searchQuery);

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.checkUrlContainsSearchQuery(searchUrl));
        Assert.assertTrue(searchPage.checkSearchResultsContainsSearchQuery("Sony Xperia Z2"));
        searchPage.clickOnFirstSmartphoneInSearchGrid();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        String actualProductTitle = productDetailsPage.getProductTitle();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }
}
