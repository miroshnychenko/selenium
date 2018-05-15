package selenium.pages.google.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailFieldLocator = By.cssSelector("input[type=\"email\"]");
    private By nextButtonEmailLocator = By.id("identifierNext");
    private By passwordFieldLocator = By.cssSelector("input[type=\"password\"]");
    private By nextButtonPasswordLocator = By.id("passwordNext");


    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void enterEmailAndCLickNext(String login) {
        enterValueAndCLickNext(login, emailFieldLocator, nextButtonEmailLocator);
    }

    public void enterPasswordAndClickNext(String password) {
        enterValueAndCLickNext(password, passwordFieldLocator, nextButtonPasswordLocator);
    }

    private WebElement waitForElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);

    }

    private void enterValueAndCLickNext(String value, By fieldLocator, By nextButtonLocator) {
        WebElement field = waitForElement(fieldLocator);
        WebElement nextButton = waitForElement(nextButtonLocator);
        field.clear();
        field.sendKeys(value);
        nextButton.click();
    }
}
