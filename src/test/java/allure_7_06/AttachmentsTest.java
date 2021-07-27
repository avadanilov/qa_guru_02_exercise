package allure_7_06;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {


    @Test
    public void testAttachments() {
        step("Сделали скрин с помощью Аннотации", () -> {
            open("https://github.com/eroshenkoam/allure-example/issues");
            annotatedAttachment();
        });
        step("Сделали скрин с помощью метода", () -> {

            String source = WebDriverRunner.getWebDriver().getPageSource();
            Allure.attachment("Исходный код страницы", source);
        });
    }


    @Attachment(value = "Screenshot", type = "img/png")
    public byte[] annotatedAttachment() {
       return Selenide.screenshot(OutputType.BYTES);
    }
}
