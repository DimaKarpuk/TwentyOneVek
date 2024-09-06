package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.FavoritePage;
import pages.MainPage;

public class AddToCartTest extends TestBase {
    MainPage mainPage = new MainPage();
    FavoritePage favoritePage = new FavoritePage();
    CartPage cartPage = new CartPage();
    TestData testData = new TestData();

    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addToCartTest() {
            cartPage.cartButtonClick();
            cartPage.checkCartIsEmpty();
            mainPage.setSearchBarrValue(testData.book);
            mainPage.goodsClick(testData.book);
            cartPage.addToCartButtonClick();
            cartPage.cartButtonClick();
            cartPage.checkCartIsNotEmpty();
    }

    @DisplayName("Тест на удаление товара из корзины")
    @Test
    void removingItemsFromCartTest() {
            mainPage.setSearchBarrValue(testData.book);
            mainPage.goodsClick(testData.book);
            cartPage.addToCartButtonClick();
            cartPage.cartButtonClick();
            cartPage.checkCartIsNotEmpty();
            cartPage.removeFromCartButtonClick();
            cartPage.agreeRemoveButtonClick();
            cartPage.checkCartIsEmpty();
    }

    @DisplayName("Тест на добавление товара в избранное")
    @Test
    void addToFavoriteTest() {
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsEmpty();
            mainPage.setSearchBarrValue(testData.painting);
            mainPage.goodsClick(testData.painting);
            favoritePage.addToFavoriteClick();
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsNotEmpty();
    }
@DisplayName("Тест на удаление товара из избранное")
    @Test
    void removingItemsFromFavoriteTest() {
            mainPage.setSearchBarrValue(testData.painting);
            mainPage.goodsClick(testData.painting);
            favoritePage.addToFavoriteClick();
            favoritePage.favoriteButtonClick();
            favoritePage.checkFavoritePageIsNotEmpty();
            favoritePage.removeFromFavoriteButtonClick();
            favoritePage.checkFavoritePageIsEmpty();
    }
}
