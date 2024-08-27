package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final SelenideElement
            accountButton = $(".styles_userToolsToggler__c2aHe"),
            loginButton = $("[data-testid = 'loginButton']"),
            loginEmailInput = $("#login-email"),
            loginPasswordInput = $("#login-password"),
            errorMessage = $(".ErrorMessage-module__message");


    @Step("Нажимаем кнопку Аккаунт")
    public RegistrationPage accountButtonClick() {
        accountButton.click();
        return this;
    }

    @Step("Нажимаем кнопку Войти")
    public RegistrationPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    @Step("Вводим email")
    public RegistrationPage setLoginEmail(String email) {
        loginEmailInput.setValue(email).pressEnter();
        return this;
    }

    @Step("Ошибка пароль не указан")
    public RegistrationPage checkPasswordErrorMessage() {
        errorMessage.shouldHave(text("Пароль не указан"));
        return this;
    }
    @Step("Вводим password")
    public RegistrationPage setLoginPassword(String password) {
        loginPasswordInput.setValue(password).pressEnter();
        return this;
    }
    @Step("Ошибка электронная почта не указана")
    public RegistrationPage checkEmailErrorMessage() {
        errorMessage.shouldHave(text("Электронная почта не указана"));
        return this;
    }
}
