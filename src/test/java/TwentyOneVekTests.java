
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

    @Test
    void registrationTest() {
        step("Нажимаем кнопку Аккаунт", () -> {
            registrationPage.accountButtonClick();
        });
        step("Нажимаем кнопку Войти", () -> {
            registrationPage.loginButtonClick();
        });
        step("Нажимаем кнопку Регистрация", () -> {
            registrationPage.registrationButtonClick();
        });
        step("Вводим валидный email", () -> {
            registrationPage.setRegisterEmail(randomUtils.randomEmail);
        });
    }

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
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Тест выбора города {0} на главной странице")
    void selectCityTest(String city) {
        step("Заходим в меню выбора города", () -> {
            mainPage.cityButtonClick();
            mainPage.clearCitySearchBarrClick();
        });
        step("Вводим в пойсковую строку город "+ city, () -> {
            mainPage.SetSearchBarrChoiceCity(city);
            mainPage.saveButtonChoiceCityClick();
        });
        step("Проверяем результат на главной странице", () -> {
            mainPage.checkResultChoiceCity(city);
        });
    }
}
