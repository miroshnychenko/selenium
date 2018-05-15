package selenium.pages.google.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebDriver driver;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstLink() {
        return driver.findElement(linkLocator);
    }
}
