package com.google.mail;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.PropertiesCache;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.mail.GmailLoginPage;
import selenium.pages.google.mail.GmailPage;

public class LoginTest extends WebDriverTestBase {
    private String email = String.valueOf(PropertiesCache.getProperty("login.username"));
    private String password = String.valueOf(PropertiesCache.getProperty("login.password"));

    @Test
    public void loginTest() {
        driver.get("https://gmail.com");
        GmailLoginPage loginPage = new GmailLoginPage(driver);
        loginPage.enterEmailAndCLickNext(email);
        loginPage.enterPasswordAndClickNext(password);

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.clickOnMyAccountIcon();

        Assert.assertTrue(gmailPage.isEmailCorrect(email));
        Assert.assertTrue(gmailPage.getInboxTableRows().size() > 0);
    }
}
