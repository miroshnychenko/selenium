package com.google;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.PropertiesCache;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.search.GoogleResultPage;
import selenium.pages.google.search.GoogleSearchPage;

@Listeners({selenium.core.TestListener.class})

public class GoogleSearchTest extends WebDriverTestBase {
    private String searchQuery = String.valueOf(PropertiesCache.getProperty("google.search.searchQuery"));

    @Test
    public void searchTest() {

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.get("https://google.com.ua");
        searchPage.search(searchQuery);

        GoogleResultPage resultPage = new GoogleResultPage(driver);
        String actual = resultPage.getFirstLink().getText();

        Assert.assertTrue(actual.contains(searchQuery), "\nExpected: Link text should contain " + searchQuery
                + "\nActual: Link text is :" + actual + "\n");
        Assert.assertTrue(resultPage.isPageTitleCorrect("Selenium - Пошук Google"));
    }

}
