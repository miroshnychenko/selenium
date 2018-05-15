package selenium.pages.stylus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pages.AbstractPage;

public class ProductDetailsPage extends AbstractPage{
    private By productTitleLocator = By.cssSelector(".title h1");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        WebElement productTitle = driver.findElement(productTitleLocator);
        return productTitle.getText();
    }
}
