package selenium.pages.google.search.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

public class GoogleResultPageWithFactory extends AbstractPage{
    @FindBy(how = How.XPATH, using = "//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a")
    private WebElement link;

    public GoogleResultPageWithFactory(WebDriver driver) {
        super(driver);
    }

    public WebElement getLink() {
        return link;
    }
}
