package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.FavoritePage;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class AddToCartTest extends TestBase {
    MainPage mainPage = new MainPage();
    FavoritePage favoritePage = new FavoritePage();
    CartPage cartPage = new CartPage();
    TestData testData = new TestData();

    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addToCartTest() {
        step("Проверяем что в корзине нет товара", () -> {
            cartPage.cartButtonClick();
            cartPage.checkCartIsEmpty();
        });
        step("Добовляем товар в корзину", () -> {
            mainPage.setSearchBarrValue(testData.book);
            mainPage.goodsClick(testData.book);
            cartPage.addToCartButtonClick();
        });
        step("Проверяем что в корзине присуствует товар", () -> {
            cartPage.cartButtonClick();
            cartPage.checkCartIsNotEmpty();
        });
    }

    @DisplayName("Тест на удаление товара из корзины")
    @Test
    void removingItemsFromCartTest() {
        step("Добовляем товар в корзину", () -> {
            mainPage.setSearchBarrValue(testData.book);
            mainPage.goodsClick(testData.book);
            cartPage.addToCartButtonClick();
        });
        step("Проверяем что в корзине присуствует товар", () -> {
            cartPage.cartButtonClick();
            cartPage.checkCartIsNotEmpty();
        });
        step("Удаляем товар из корзины", () -> {
            cartPage.removeFromCartButtonClick();
            cartPage.agreeRemoveButtonClick();
        });
        step("Проверяем что в корзине нет товара", () -> {
            cartPage.checkCartIsEmpty();
        });
    }

    @DisplayName("Тест на добавление товара в избранное")
    @Test
    void addToFavoriteTest() {
        step("Проверяем что в избранном нет товара", () -> {
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsEmpty();
        });
        step("Добовляем товар в избранное", () -> {
            mainPage.setSearchBarrValue(testData.painting);
            mainPage.goodsClick(testData.painting);
            favoritePage.addToFavoriteClick();
        });
        step("Проверяем что в избранном присуствует товар", () -> {
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsNotEmpty();
        });
    }
@DisplayName("Тест на удаление товара из избранное")
    @Test
    void removingItemsFromFavoriteTest() {
        step("Добовляем товар в избранное", () -> {
            mainPage.setSearchBarrValue(testData.painting);
            mainPage.goodsClick(testData.painting);
            favoritePage.addToFavoriteClick();
        });
        step("Проверяем что в избранном присуствует товар", () -> {
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsNotEmpty();
        });
        step("Удаляем товар из избранное", () -> {
            favoritePage.removeFromFavoriteButtonClick();
        });
        step("Проверяем что в избранном нет товара", () -> {
            favoritePage.checkFavoritePageIsEmpty();
        });
    }
}
