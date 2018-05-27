package selenium.pages.tomascook.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import selenium.pages.AbstractPage;

import java.util.List;

public class SearchForm extends AbstractPage {
    @FindBy(how = How.CSS, using = "#SearchbarForm-destinationContainer .FormField-withButton")
    private WebElement destinationInputform;

    @FindBy(how = How.ID, using = "SearchbarForm-goingTo")
    private WebElement destinationInput;

    @FindBy(how = How.ID, using = "SearchbarForm-submitBtn")
    private WebElement searchFormSubmit;

    private List<WebElement> suggestedDestinations;

    public SearchForm(WebDriver driver) {
        super(driver);
    }

    public void searchTrip(String destination) throws InterruptedException {
        destinationInputform.click();
        destinationInput.sendKeys(destination);
        Thread.sleep(2000);
        List<WebElement> suggestedDestinations = getSuggestions();
        Thread.sleep(3000);
        suggestedDestinations.get(0).click();
        /*destinationInput.clear();
        destinationInput.sendKeys(text);
        */
        searchFormSubmit.click();
    }

    private List<WebElement> getSuggestions() {
       return driver.findElements(By.xpath("//*[@id=\"SearchbarForm-destinationContainer\"]/div/div/div/tc-typeahead/div/div[1]/div/div[2]/ul"));
    }
}
