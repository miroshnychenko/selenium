package learnJavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.learnJavaScript.DragAndDropPage;

public class DragAndDropTest extends WebDriverTestBase{

    @Test
    public void dragAndDrop() {
        driver.get("https://learn.javascript.ru/drag-and-drop-objects");
        DragAndDropPage w3schools = PageFactory.initElements(driver, DragAndDropPage.class);
        w3schools.switchToFrame();
        w3schools.dragAndDrop();

        WebElement result = driver.findElement(By.cssSelector("div > img"));

        Assert.assertTrue(result.isDisplayed());
    }
}
