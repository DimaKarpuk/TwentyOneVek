package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class LoginTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @DisplayName("Тест на авторизацию без Email")
    @Test
    void incorrectLoginWithOutEmailTest() {
            registrationPage.accountButtonClick();
            registrationPage.loginButtonClick();
            registrationPage.setLoginEmail(randomUtils.randomEmail);
            registrationPage.checkPasswordErrorMessage();
    }

    @DisplayName("Тест на авторизацию без Пароля")
    @Test
    void incorrectLoginWithOutPasswordTest() {
            registrationPage.accountButtonClick();
            registrationPage.loginButtonClick();
            registrationPage.setLoginPassword(randomUtils.randomPassword);
            registrationPage.checkEmailErrorMessage();
    }
}
