package selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverTestBase {
    protected WebDriver driver;
    private String browser = System.getProperty("browser", CHROME);
    private long implicitlyWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    private long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.page"));
    private long setScriptTimeout = Long.parseLong(PropertiesCache.getProperty("wait.script"));

    @BeforeClass
    public void setUp() {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(setScriptTimeout, TimeUnit.SECONDS);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
                driver.manage().timeouts().setScriptTimeout(setScriptTimeout, TimeUnit.SECONDS);
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
