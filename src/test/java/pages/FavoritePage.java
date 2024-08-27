package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {
    private final SelenideElement
    favoriteButton = $(".headerFavoritesIcon"),
    favoritePageIsEmpty = $(byTagAndText("div","Нет избранных товаров")),
    addToFavorite = $("[aria-label = 'В избранное']"),
    removeFromFavoriteButton = $(".OldProductCard_removeBtn__Comnc");

    @Step("Нажимаем кнопку Избранное")
    public FavoritePage favoriteButtonClick(){
        favoriteButton.click();
        return this;
    }
    @Step("Проверяем что в избранном нет товара")
    public FavoritePage checkFavoritePageIsEmpty(){
        favoritePageIsEmpty.shouldBe(visible);
        return this;
    }
    @Step("Проверяем что в избранном присуствует товар")
    public FavoritePage checkFavoritePageIsNotEmpty(){
        favoritePageIsEmpty.shouldNotBe(visible);
        return this;
    }
    @Step("Добовляем товар в избранное")
    public FavoritePage addToFavoriteClick(){
        addToFavorite.click();
        return this;
    }
    @Step("Нажимаем кнопку удалить из избранное")
    public FavoritePage removeFromFavoriteButtonClick(){
        removeFromFavoriteButton.click();
        return this;
    }
}
