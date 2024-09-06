package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPage {
    private final SelenideElement
            selectCategory = $(".styles_promoList__yozMt"),
            visibilityCheck = $("h1");

    @Step("Кликаем по категории")
    public void categorySelect(String value) {
        selectCategory.$(byText(value)).click();
    }

    @Step("Прверяем результат перехода на страницу категории")
    public void checkExpectedValue(String value) {
        visibilityCheck.shouldHave(text(value)).shouldBe(visible);
    }
}
