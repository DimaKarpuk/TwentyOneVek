package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            searchBarr = $("#catalogSearch"),
            goods = $(".result__name");

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
}
