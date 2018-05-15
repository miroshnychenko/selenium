package selenium.pages.google.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private By searchLocator = By.name("q");
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public void search(String text) {
        WebElement searchField = driver.findElement(searchLocator);
        searchField.sendKeys(text);
        searchField.submit();
    }
}
