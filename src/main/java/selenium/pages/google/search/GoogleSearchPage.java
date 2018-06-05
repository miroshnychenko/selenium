package selenium.pages.google.search;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.AbstractPage;

public class GoogleSearchPage extends AbstractPage{

    private By searchLocator = By.name("q");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get to the url")
    public void get(String url) {
        driver.get(url);
    }
    @Step("Search for selenium")
    public void search(String text) {
        WebElement searchField = driver.findElement(searchLocator);
        searchField.sendKeys(text);
        searchField.submit();
    }
}
