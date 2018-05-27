package selenium.pages.w3schools;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

public class AlertPage extends AbstractPage {

    @FindBy(how = How.ID, using = "iframeResult")
    private WebElement iframe;

    @FindBy(how = How.CSS, using = "body h2 + button")
    private WebElement tryButton;

    @FindBy(how = How.ID, using = "demo")
    private WebElement confirmationText;

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public void clickOnTryButton() {
        tryButton.click();
    }

    public void clickOnTryButtonWithJS() {
        String tryButtonLocator = "h2 + button";
        String js = "document.querySelector(\""+tryButtonLocator+"\").click();";
        ((JavascriptExecutor)driver).executeScript(js);
    }

    public void clickOkOnAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickCancelOnAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public boolean VerifyConfirmationText (String text) {
        return confirmationText.getText().equals(text);
    }
}
