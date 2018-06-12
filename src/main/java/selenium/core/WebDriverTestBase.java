package selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@Listeners({selenium.core.TestListener.class})

public class WebDriverTestBase {
    protected WebDriver driver;
    private String browser = System.getProperty("browser", CHROME);
    private long implicitlyWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    private long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.page"));
    private long setScriptTimeout = Long.parseLong(PropertiesCache.getProperty("wait.script"));

    private DesiredCapabilities setDesiredCapabilities(String platform, String remoteBrowser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase(Platform.SIERRA.name())) {
            caps.setPlatform(Platform.SIERRA);
            caps.setBrowserName(remoteBrowser);
        }
        return caps;
    }

    @Parameters({"platform", "remoteBrowser"})
    @BeforeClass
    public void setUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
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
            case "remote":
                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
