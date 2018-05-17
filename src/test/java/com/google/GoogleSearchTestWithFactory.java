package com.google;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.PropertiesCache;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.search.factory.GoogleResultPageWithFactory;
import selenium.pages.google.search.factory.GoogleSearchPageWithFactory;

public class GoogleSearchTestWithFactory extends WebDriverTestBase{
    private String searchQuery = String.valueOf(PropertiesCache.getProperty("google.search.searchQuery"));

    @Test
    public void searchFor() {
        driver.get("https://google.com.ua");
        GoogleSearchPageWithFactory searchPage = PageFactory.initElements(driver, GoogleSearchPageWithFactory.class);
        searchPage.search(searchQuery);

        GoogleResultPageWithFactory resultPage = PageFactory.initElements(driver, GoogleResultPageWithFactory.class);
        String actual = resultPage.getFirstLink().getText();

        Assert.assertTrue(actual.contains(searchQuery), "\nExpected: Link text should contain \"Selenium\" \nActual: Link text is :" + actual + "\n");


    }
}
