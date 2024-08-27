package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
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
}
