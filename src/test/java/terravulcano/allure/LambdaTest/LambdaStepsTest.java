package terravulcano.allure.LambdaTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 65;
    private final String BASE_URL = "https://github.com";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Тест с лябмда шагами")
    public void SearchForIssue() {

        Allure.parameter("Url", BASE_URL);
        Allure.parameter("Repository", REPOSITORY);
        Allure.parameter("Issue Number", ISSUE_NUMBER);

        step("Окрываем главную страницу", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue номер 68", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
