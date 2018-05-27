package tomascook;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import selenium.core.WebDriverTestBase;
import selenium.pages.tomascook.homepage.SearchForm;


public class SearchTest extends WebDriverTestBase{

    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://www.thomascook.com/");
        driver.navigate().refresh();
        SearchForm searchForm = PageFactory.initElements(driver, SearchForm.class);

        searchForm.searchTrip("Turkey");
    }
}
