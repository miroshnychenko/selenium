package selenium.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    private WebDriver driver;
    private By productTitleLocator = By.cssSelector(".title h1");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        WebElement productTitle = driver.findElement(productTitleLocator);
        return productTitle.getText();
    }
}
