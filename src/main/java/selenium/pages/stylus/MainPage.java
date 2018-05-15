package selenium.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.AbstractPage;

public class MainPage extends AbstractPage{
    private By searchFieldLocator = By.name("q");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void search(String searchQuery) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.clear();
        searchField.sendKeys(searchQuery);
        searchField.submit();
    }
}
