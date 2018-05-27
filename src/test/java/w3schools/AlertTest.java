package w3schools;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.w3schools.AlertPage;

public class AlertTest extends WebDriverTestBase{

    @Test
    public void alertTest(){
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

        AlertPage alertPage = PageFactory.initElements(driver, AlertPage.class);
        alertPage.switchToFrame();
        alertPage.clickOnTryButton();
        alertPage.clickOkOnAlert();
        Assert.assertTrue(alertPage.VerifyConfirmationText("You pressed OK!"));
        alertPage.clickOnTryButtonWithJS();
        alertPage.clickCancelOnAlert();
        Assert.assertTrue(alertPage.VerifyConfirmationText("You pressed Cancel!"));
    }
}
