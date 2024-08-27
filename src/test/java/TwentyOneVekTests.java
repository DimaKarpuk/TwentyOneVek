
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.FavoritePage;
import pages.MainPage;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;


public class TwentyOneVekTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    FavoritePage favoritePage = new FavoritePage();
    CartPage cartPage = new CartPage();
    TestData testData = new TestData();
    RandomUtils randomUtils = new RandomUtils();

    @DisplayName("Тест на авторизацию без Email")
    @Test
    void incorrectLoginWithOutEmailTest() {
        step("Нажимаем кнопку Аккаунт", () -> {
            registrationPage.accountButtonClick();
        });
        step("Нажимаем кнопку Войти", () -> {
            registrationPage.loginButtonClick();
        });
        step("Вводим Email", () -> {
            registrationPage.setLoginEmail(randomUtils.randomEmail);
        });
        step("Проверяем что вход не выполнен", () -> {
            registrationPage.checkPasswordErrorMessage();
        });
    }

    @DisplayName("Тест на авторизацию без Пароля")
    @Test
    void incorrectLoginWithOutPasswordTest() {
        step("Нажимаем кнопку Аккаунт", () -> {
            registrationPage.accountButtonClick();
        });
        step("Нажимаем кнопку Войти", () -> {
            registrationPage.loginButtonClick();
        });
        step("Вводим Email", () -> {
            registrationPage.setLoginPassword(randomUtils.randomPassword);
        });
        step("Проверяем что вход не выполнен", () -> {
            registrationPage.checkEmailErrorMessage();
        });
    }

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
