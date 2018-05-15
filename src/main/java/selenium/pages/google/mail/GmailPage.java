package selenium.pages.google.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By accountIconLocator = By.cssSelector(".gb_db.gbii");
    private By inboxTableRowsLocator = By.cssSelector(".Cp table tr");
    private By accoutEmailLocator = By.cssSelector(".gb_Cb .gb_Ib");

    public GmailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickOnMyAccountIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(accountIconLocator));
        WebElement accountIcon = driver.findElement(accountIconLocator);
        accountIcon.click();
    }

    public List getInboxTableRows() {
        return driver.findElements(inboxTableRowsLocator);
    }

    public boolean isEmailCorrect(String email) {
        WebElement accountEmail = driver.findElement(accoutEmailLocator);
        return accountEmail.getText().equals(email);
    }
}
