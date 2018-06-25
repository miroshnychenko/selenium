package selenide;

import org.testng.annotations.Test;
import selenide.Pages.google.SearchPage;
import selenide.Pages.google.SearchResutlsPage;
import selenide.core.SelenideTestBase;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class GoogleSearchTest extends SelenideTestBase{

    @Test
    public void searchTest() {
        open("https://google.com");
        SearchPage searchPage = new SearchPage();
        searchPage.searchFor("Selenide");

        SearchResutlsPage searchResutlsPage = new SearchResutlsPage();
        searchResutlsPage
                .getLinksResult()
                .shouldHaveSize(10)
                .first()
                .should(text("Selenide"));
    }
}
