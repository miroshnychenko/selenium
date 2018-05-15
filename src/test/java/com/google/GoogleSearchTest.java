package com.google;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.search.GoogleResultPage;
import selenium.pages.google.search.GoogleSearchPage;

public class GoogleSearchTest extends WebDriverTestBase {

    @Test
    public void searchTest() {

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.get("https://google.com.ua");
        searchPage.search("Selenium");

        GoogleResultPage resultPage = new GoogleResultPage(driver);
        String actual = resultPage.getFirstLink().getText();

        String expected = "Selenium";

        Assert.assertTrue(actual.contains(expected), "\nExpected: Link text should contain " + expected
                + "\nActual: Link text is :" + actual + "\n");
    }
}
