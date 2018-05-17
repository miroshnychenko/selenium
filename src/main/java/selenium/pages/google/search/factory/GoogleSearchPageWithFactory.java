package selenium.pages.google.search.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

public class GoogleSearchPageWithFactory extends AbstractPage{

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    public GoogleSearchPageWithFactory(WebDriver driver) {
        super(driver);
    }
    public void search(String text) {
        searchField.sendKeys(text);
        searchField.submit();
    }
}
