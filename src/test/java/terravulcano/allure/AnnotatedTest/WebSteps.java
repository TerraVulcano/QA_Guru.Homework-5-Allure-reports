package terravulcano.allure.AnnotatedTest;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Окрываем главную страницу {url}")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий{repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в таб Issues")
    public void clickOnIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue номер {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
    }
}
