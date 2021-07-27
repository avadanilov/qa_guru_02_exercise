package allure_7_06;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "68";

    private WebSteps steps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository(){
        steps.openMainPage();
        steps.serachForRepositoty(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssueWithNumber(ISSUE_NUMBER);
    }
}
