package com.google.mail;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.google.mail.GmailLoginPage;
import selenium.pages.google.mail.GmailPage;

public class LoginTest extends WebDriverTestBase {

    @Test
    public void loginTest() {
        String email = "kitautotest@gmail.com";
        String password = "Qwer1234!";

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
