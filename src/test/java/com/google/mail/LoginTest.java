package com.google.mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        String login = "kitautotest";
        String password = "Qwer1234!";

        driver.get("https://gmail.com");

        WebElement emailField = driver.findElement(By.cssSelector("input[type=\"email\"]"));
        WebElement nextButtonEmail = driver.findElement(By.id("identifierNext"));

        emailField.clear();
        emailField.sendKeys(login);
        nextButtonEmail.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement nextButtonPassword = driver.findElement(By.id("passwordNext"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"password\"]")));
        passwordField.clear();
        passwordField.sendKeys(password);
        nextButtonPassword.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".gb_db.gbii")));
        WebElement accountIcon = driver.findElement(By.cssSelector(".gb_db.gbii"));
        accountIcon.click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".gb_Cb .gb_Ib")).getText().equals("kitautotest@gmail.com"));
        Assert.assertTrue(driver.findElements(By.cssSelector(".Cp table tr")).size()>0);
    }
}
