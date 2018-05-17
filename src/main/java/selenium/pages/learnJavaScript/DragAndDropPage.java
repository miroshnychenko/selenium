package selenium.pages.learnJavaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

public class DragAndDropPage extends AbstractPage {
    @FindBy(how = How.CLASS_NAME, using = "code-result__iframe")
    private WebElement iframe;

    @FindBy(how = How.CLASS_NAME, using = "draggable")
    private WebElement picture;

    @FindBy(how = How.CLASS_NAME, using = "droppable")
    private WebElement inputField;

    private Actions builder;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        builder = new Actions(driver);
    }


    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }

    public void dragAndDrop() {
        Action dragAndDrop = builder.clickAndHold(picture).moveToElement(inputField).release(inputField).build();
        dragAndDrop.perform();

    }
}
