package equerest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "selenium.com.equerest.pages.steps")
public class RunFeatures extends AbstractTestNGCucumberTests {

}