package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement
            cartButton = $(".headerCartIcon"),
            cartIsEmpty = $(".EmptyBasket_emptyViewed__rpF6R"),
            addToCartButton = $("[aria-label = 'Добавить в корзину']");

    @Step("Нажимаем кнопку Корзина")
    public CartPage cartButtonClick() {
        cartButton.click();
        return this;
    }

    @Step("Проверяем что в корзине нет товара")
    public CartPage checkCartIsEmpty() {
        cartIsEmpty.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем кнопку добавить в корзину")
    public CartPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    @Step("Проверяем что в корзине есть товар")
    public CartPage checkCartIsNotEmpty() {
        cartIsEmpty.shouldNotBe(visible);
        return this;
    }
}
