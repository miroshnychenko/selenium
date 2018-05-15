package selenium.pages.google.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.pages.AbstractPage;

public class GmailLoginPage extends AbstractPage{


    private By emailFieldLocator = By.cssSelector("input[type=\"email\"]");
    private By nextButtonEmailLocator = By.id("identifierNext");
    private By passwordFieldLocator = By.cssSelector("input[type=\"password\"]");
    private By nextButtonPasswordLocator = By.id("passwordNext");


    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndCLickNext(String login) {
        enterValueAndCLickNext(login, emailFieldLocator, nextButtonEmailLocator);
    }

    public void enterPasswordAndClickNext(String password) {
        enterValueAndCLickNext(password, passwordFieldLocator, nextButtonPasswordLocator);
    }

    private void enterValueAndCLickNext(String value, By fieldLocator, By nextButtonLocator) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(fieldLocator));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));;
        field.clear();
        field.sendKeys(value);
        nextButton.click();
    }
}
