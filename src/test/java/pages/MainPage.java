package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            searchBarr = $("#catalogSearch"),
            goods = $(".result__name"),
            selectCategory = $(".styles_promoList__yozMt"),
            visibilityCheck = $("h1");
    ;

    @Step("Вводим в пойсковую строку название товара")
    public MainPage setSearchBarrValue(String nameGoods) {
        searchBarr.setValue(nameGoods).pressEnter();
        return this;
    }

    @Step("Открываем страницу товара")
    public MainPage goodsClick(String nameGoods) {
        goods.shouldHave(text(nameGoods)).click();
        return this;
    }

    @Step("Кликаем по категории")
    public void categorySelect(String value) {
        selectCategory.$(byText(value)).click();
    }

    @Step("Прверяем результат перехода на страницу категории")
    public void checkExpectedValue(String value) {
        visibilityCheck.shouldHave(text(value)).shouldBe(visible);
    }
}
