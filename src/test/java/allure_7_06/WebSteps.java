package allure_7_06;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step ("Ищем репозиторий [{repository}]")
    public void serachForRepositoty(String repository){

    }
    @Step("Переходим в репозиторий [{repository}]")
    public void goToRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
    }
    @Step("Переходим в раздел Issues")
    public void openIssueTab(){
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
    }
    @Step("Проверяем, что есть иссью с номером [{issueNumber}]")
    public void checkIssueWithNumber(String issueNumber){
        $(withText("#"+issueNumber)).shouldHave(Condition.exist);
    }


}
