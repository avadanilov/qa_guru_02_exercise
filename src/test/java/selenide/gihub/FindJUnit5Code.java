package selenide.gihub;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5Code {

    @Test
    void findJUnit5Code() {
        open("https://github.com/selenide/selenide");
        $("[data-content=Wiki]").click();
        //количество разделов может поменяться, поэтому кнопки Show 1 more pages… может не быть
        try {
            $(byText("Show 1 more pages…")).click();
        } catch (NoSuchElementException ignored) {
        }

        $(byText("SoftAssertions")).click();
        $(byText("Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
