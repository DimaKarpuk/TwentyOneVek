package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.testng.reporters.jq.Main;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            searchBarr = $("#catalogSearch"),
            goods = $(".result__name"),
            cityButton = $(".styles_localityBtn__qrGFQ"),
            clearCitySearchBarr = $(".BaseSuggest-module__clearIndicator"),
            searchBarrChoiceCity = $("#react-select-2-listbox"),
            saveButtonChoiceCityButton = $(". style_baseActionButtonMargin__4haYC");

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

    @Step("Нажимаем кнопку выбора города")
    public MainPage cityButtonClick() {
        cityButton.click();
        return this;
    }

    @Step("Очищаем пойсковую строку выбора города")
    public MainPage clearCitySearchBarrClick() {
        clearCitySearchBarr.click();
        return this;
    }

    @Step("Выбираем город")
    public MainPage SetSearchBarrChoiceCity(String nameCity) {
        searchBarrChoiceCity.$(byText(nameCity)).click();
        return this;
    }

    @Step("Нажимаем кнопку сохранить выбор города")
    public MainPage saveButtonChoiceCityClick() {
        saveButtonChoiceCityButton.click();
        return this;
    }
    @Step("Проверяем результат выбора города")
    public MainPage checkResultChoiceCity(String nameCity){
        cityButton.shouldHave(text(nameCity));
        return this;
    }
}
