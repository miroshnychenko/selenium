package selenium.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private By searchFieldLocator = By.name("q");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String searchQuery) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.clear();
        searchField.sendKeys(searchQuery);
        searchField.submit();
    }
}
