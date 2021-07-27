package allure_7_06;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LablesTest {
    @Test
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Owner("danilov")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "GitHub", url = "https://github.com", type="")
    @Description("Здесь какие-то большие описания теста")
    @DisplayName("Проверка работы поиска по Issues Через Аннотации")
    public void testLablesWithAnnotations() {
    }


    @Test
    @DisplayName("Проверка работы поиска по Issues Через методы")
    public void testLablesWithMethods() {
        Allure.feature("Issues");
        Allure.story("Поиск по Issue");
        Allure.label("owner", "danilov");
        Allure.label("severity", SeverityLevel.CRITICAL.toString());
        Allure.link("GitHub", "https://github.com");
        Allure.description("здесь текст");
    }


}
