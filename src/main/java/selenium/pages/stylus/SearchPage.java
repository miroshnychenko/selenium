package selenium.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private By foundProductsListLocator = By.cssSelector(".product-grid .item span.title");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSearchResultsContainsSearchQuery(String searchQuery) {
        List<WebElement> foundProducts = driver.findElements(foundProductsListLocator);
        boolean flag = false;
        for (WebElement item : foundProducts) {
            if (item.getText().contains(searchQuery)) flag = true;
        }
        return flag;
    }

    public void clickOnFirstSmartphoneInSearchGrid() {
        List<WebElement> foundProducts = driver.findElements(foundProductsListLocator);
        for (WebElement item : foundProducts) {
            if (item.getText().contains("Смартфон")) {
                item.click();
                break;
            }
        }
    }

    public boolean checkUrlContainsSearchQuery(String query) {
        return driver.getCurrentUrl().contains(query);
    }
}
