package selenium.com.equerest.pages.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.com.equerest.pages.RegisterPage;

public class EnterpreneurSteps {

    public static final String REGISTER_PAGE = "https://dev.equerest.com/register#/entrepreneur";

    private WebDriver webDriver;
    private RegisterPage registerPage;

    @Given("^I am on new project registration page")
    public void openRegisterPage() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.get(REGISTER_PAGE);
    }

    @When("^I fill my first name \"([^\"]*)\" and last name \"([^\"]*)\"")
    public void fillFirstAndLastName(String firstName, String lastName) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillFIO(firstName, lastName);
    }

    @When("^I fill my city \"([^\"]*)\"")
    public void fillCity(String city) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillCity(city);
    }

    @When("^I fill my phone \"([^\"]*)\"")
    public void fillPhone(String phone) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillPhone(phone);
    }

    @When("^I fill my email \"([^\"]*)\"")
    public void fillEmail(String email) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillEmail(email);
    }


    @When("^I fill my password \"([^\"]*)\"")
    public void fillPassword(String password) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillFPassword(password);
    }

    @When("^I click next button")
    public void clickNext() {
        registerPage = new RegisterPage(webDriver);
        registerPage.clickNextButton();
    }

    @Then("^I am on second step")
    public void isOnSecondStep() throws InterruptedException{
        registerPage = new RegisterPage(webDriver);;
        registerPage.isOnSecondPage();
    }

    @When("^I fill project name \"([^\"]*)\"")
    public void fillProjectName(String projectTitle) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillProjectTitle(projectTitle);
    }

    @When("^I fill project description \"([^\"]*)\"")
    public void fillDescription(String description) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillProjectDescription(description);
    }

    @When("^I select project satge 0")
    public void selectStage() {
        registerPage = new RegisterPage(webDriver);
        registerPage.selectProjectStage0();
    }

    @When("^I fill advantages \"([^\"]*)\"")
    public void fillAdvantages(String advantages) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillAdvantages(advantages);
    }

    @When("^I fill monetization model \"([^\"]*)\"")
    public void fillMonetization(String monetization) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillMonetizationModel(monetization);
    }

    @When("^I fill required amount \"([^\"]*)\"")
    public void fillRequiredAmount(String amount) {
        registerPage = new RegisterPage(webDriver);
        registerPage.fillRequiredAmount(amount);
    }

    @When("^I click agree checkbox")
    public void clickAgree() {
        registerPage = new RegisterPage(webDriver);
        registerPage.checkAgreeCheckbox();
    }

    @When("^I click submit button")
    public void clickSubmit() {
        registerPage = new RegisterPage(webDriver);
        registerPage.clickSubmitButton();
    }

}