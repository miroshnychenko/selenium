package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;

import static org.testng.AssertJUnit.assertTrue;



public class GoogleSearchTest extends WebDriverTestBase {

    private String googleSearch = "https://www.google.com.ua/";
    private String searchText = "Selenium";


    @Test
    public void searchTest() {
        driver.get(googleSearch);
        By searchLocator = By.name("q");
        WebElement searchField = driver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = driver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));
    }
}
