package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {

    private static final String FORM_TITLE = "Student Registration Form";
    private static final String RESULTS_TITLE = "Thanks for submitting the form";

    private SelenideElement modal = $("[role=dialog]");
    private Calendar calendar = new Calendar();

    public void
    openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String firstName) {
        $("input#firstName").val(firstName);
    }

    public void typeLastName(String lastName) {
        $("input#firstName").val(lastName);
    }

    public void checkResultsTitle() {
        modal.$(".modal-title").shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue() {
        modal.$(".table-responsive").shouldHave(text("FirstName LastName"));
    }

    public RegistrationPage typeEmail() {
        $("input#userEmail").shouldHave(text(RESULTS_TITLE));
        return this;
    }

    public RegistrationPage selectGender(String gender) {

        /*
         * String a = "123%s789";
         * String b = format(a,456);
         * если вывести "b" в лог, то -> 123456789
         *
         * String a = "123%s7%s9";
         * String b = format(a,456,8);
         * если вывести "b" в лог, то -> 123456789
         * */
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeUserNumber(String number) {
        $("input#userNumber").val("1798765432");
        return this;
    }
}
