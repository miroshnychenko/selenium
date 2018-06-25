package selenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;



public class SelenideStylusTest extends SelenideTestBase{

    @Test
    public static void stylusSearch() {
        open("https://www.stylus.com.ua");
        $(By.name("q")).val("Sony Z2").submit();
        $("#search-list > ul > li:nth-child(2) > a > span")
                .should(visible, text("Sony Xperia Z2"))
                .click();
        $(".title h1")
                .should(visible, text("Смартфон Sony Xperia Z2 Black"));


    }

}
