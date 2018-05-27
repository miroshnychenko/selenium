package selenium.pages.tomascook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

public class HomePage extends AbstractPage{

    @FindBy (how = How.CLASS_NAME, using = "brandLogo")
    private WebElement logo;

    @FindBy (how = How.CLASS_NAME, using = "navbar-collapse")
    private WebElement topNavigationBar;

    @FindBy (how = How.CLASS_NAME, using = "googleSearch-headerContainer")
    private WebElement searchBar;

    @FindBy (how = How.CSS, using = "footer.footer")
    private WebElement footer;



    public HomePage(WebDriver driver) {
        super(driver);
    }



    public boolean isLogoPresent() {
        return logo.isDisplayed();
    }

    public boolean isTopNavigationBarPresent() {
        return topNavigationBar.isDisplayed();
    }

    public boolean isSearchBarPresent() {
        return searchBar.isDisplayed();
    }

    public boolean isFooterPresent() {
        return footer.isDisplayed();
    }
}
