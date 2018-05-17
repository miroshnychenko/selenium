package com.google;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.search.factory.GoogleResultPageWithFactory;
import selenium.pages.google.search.factory.GoogleSearchPageWithFactory;

public class GoogleSearchTestWithFactory extends WebDriverTestBase{
    @Test
    public void searchFor() {
        driver.get("https://google.com.ua");
        GoogleSearchPageWithFactory searchPage = PageFactory.initElements(driver, GoogleSearchPageWithFactory.class);
        searchPage.search("Selenium");

        GoogleResultPageWithFactory resultPage = PageFactory.initElements(driver, GoogleResultPageWithFactory.class);
        String actual = resultPage.getFirstLink().getText();

        Assert.assertTrue(actual.contains("Selenium"), "\nExpected: Link text should contain \"Selenium\" \nActual: Link text is :" + actual + "\n");


    }
}
