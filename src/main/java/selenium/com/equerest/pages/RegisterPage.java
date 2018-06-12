package selenium.com.equerest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage {

    private WebDriver webDriver;


    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillFIO(String firstName, String lastName) {
        WebElement fio = webDriver.findElement(By.id("fio"));
        fio.sendKeys(firstName + " " + lastName);
    }

    public void fillPhone(String phone) {
        WebElement phoneField = webDriver.findElement(By.id("tel"));
        phoneField.sendKeys(phone);
    }

    public void fillCity(String city) {
        WebElement cityField = webDriver.findElement(By.id("city"));
        cityField.sendKeys(city);
    }

    public void fillEmail(String email) {
        WebElement emailField = webDriver.findElement(By.id("mail"));
        emailField.sendKeys(email);
    }

    public void fillFPassword(String password) {
        WebElement passwordField = webDriver.findElement(By.id("pass"));
        passwordField.sendKeys(password);
    }

    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(By.cssSelector(".button-blue.button-next"));
        nextButton.click();
    }

    public void isOnSecondPage() throws InterruptedException{
        Thread.sleep(3000);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://dev.equerest.com/register#/entrepreneur/project"));
    }

    public void fillProjectTitle(String title) {
        WebElement projectTitle = webDriver.findElement(By.id("title"));
        projectTitle.sendKeys(title);
    }

    public void fillProjectDescription(String description) {
        WebElement projectDescriptions = webDriver.findElement(By.id("full_description"));
        projectDescriptions.sendKeys(description);
    }

    public void selectProjectStage0() {
        WebElement stage0 = webDriver.findElement(By.cssSelector(".radio-group"));
        stage0.click();
    }

    public void fillAdvantages(String advantages) {
        WebElement advantagesFields = webDriver.findElement(By.id("advantages"));
        advantagesFields.sendKeys(advantages);
    }

    public void fillMonetizationModel(String model) {
        WebElement monetizationModel = webDriver.findElement(By.id("monetization_model"));
        monetizationModel.sendKeys(model);
    }

    public void fillRequiredAmount(String amount) {
        WebElement requiredAmount = webDriver.findElement(By.id("required_amount"));
        requiredAmount.sendKeys(amount);
    }

    public void checkAgreeCheckbox() {
        WebElement agreeCheckbox = webDriver.findElement(By.className("input-checkbox"));
        agreeCheckbox.click();
    }


    public void clickSubmitButton() {
        WebElement submitButton = webDriver.findElement(By.cssSelector(".form-controls button"));
        submitButton.click();
    }
}