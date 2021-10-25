package terravulcano.allure.AnnotatedTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 65;
    private final String BASE_URL = "https://github.com";

    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Тест с аннотациями")
    public void searchForIssue() {
        steps.openMainPage(BASE_URL);
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }
}
