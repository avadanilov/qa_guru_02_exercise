import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithPOTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
     }

    @Test
    void positiveFillTest() {
        String date = "28";
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("input#firstName").val("FirstName");
        $("input#lastName").val("LastName");
        $("input#userEmail").val("qqq@www.eee");
        $("[name=gender][value=Male]").parent().click();
        $("input#userNumber").val("1798765432");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__day--0" + date + ":not(.react-datepicker__day--outside-month").click();
        $("#subjectsInput").val("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("./img/1.png");
        $("#currentAddress").val("Some Address, dom 1, kv 7");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("FirstName LastName"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("FirstName LastName"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("qqq@www.eee"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1798765432"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 July,2005"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some Address, dom 1, kv 7"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
   }
}
