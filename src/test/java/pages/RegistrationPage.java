package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final SelenideElement
            accountButton = $(".styles_userToolsToggler__c2aHe"),
            loginButton = $("[data-testid = 'loginButton']"),
            registrationButton = $(byTagAndText("button", "Регистрация")),
            registerEmail = $("#register-email");

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

    @Step("Нажимаем кнопку Регистрация")
    public RegistrationPage registrationButtonClick() {
        registrationButton.click();
        return this;
    }

    @Step("Вводим email")
    public RegistrationPage setRegisterEmail(String email) {
        registerEmail.setValue(email);
        return this;
    }
}
