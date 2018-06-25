package selenide.Pages.google;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResutlsPage {

    private ElementsCollection linksResult = $$("h3 a");

    public ElementsCollection getLinksResult() {
        return linksResult;
    }
}
