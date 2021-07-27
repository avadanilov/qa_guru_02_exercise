package selenide.gihub;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    @Test
    void firsContributorShouldBeSolntsev() {
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div")
                .$("ul li")
                .hover();
        $$(".Popover-message")
                .findBy(Condition.visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
