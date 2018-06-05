package selenium.pages.google.search;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.pages.AbstractPage;

public class GoogleResultPage extends AbstractPage{
    private By linkLocator = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");


    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }
    @Step("Get first link")
    public WebElement getFirstLink() {
        return driver.findElement(linkLocator);
    }

    @Step("Check page title")
    public boolean isPageTitleCorrect(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }
}
