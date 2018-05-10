package ua.com.stylus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class StylusTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void StylusSearchTest() {
        driver.get("https://stylus.com.ua");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys("Sony Z2");
        searchField.submit();
        ArrayList<WebElement> items = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".product-grid .item span.title")));

        boolean flag = false;
        for (WebElement item : items) {
            if (item.getText().contains("Sony Xperia Z2")) flag = true;
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("Sony+Z2"), "URL does not contain search query");
        Assert.assertTrue(flag, "Items do not contain \"Sony Xperia Z2\" in titles");

        for (WebElement item : items) {
            if (item.getText().contains("Смартфон")) {
                item.click();
                break;
            }
        }

        WebElement itemPageTitle = driver.findElement(By.cssSelector(".title h1"));
        Assert.assertTrue(itemPageTitle.getText().equals("Смартфон Sony Xperia Z2 Black"),
                "Item title is not \"Смартфон Sony Xperia Z2 Black\"");
        Assert.assertTrue(driver.getCurrentUrl().contains("sony-xperia-z2-black"));
    }
}
