package selenide.gihub;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideRepositoty() {
        open ("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $(".repo-list");
        var firstLinkFound=$$(".repo-list li").first().$("a");
        firstLinkFound.click();
        $("h1").shouldHave(text("selenide\n/\nselenide"));
    }
}
