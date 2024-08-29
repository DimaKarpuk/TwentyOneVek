package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class CategoryTest extends TestBase {
    MainPage mainPage = new MainPage();
    @DisplayName("Тест кликабельности категории на главной странице")
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Тест кликабельности категории {0} на главной странице")
    void choiceCategoryTest(String testData, String expectedValue){
        step("Кликаем по категории " + testData +" товара на главной странице", () -> {
            mainPage.categorySelect(testData);
        });
        step("Проверяем результат перехода на страницу категории " + testData , () -> {
            mainPage.checkExpectedValue(expectedValue);
        });
    }
}
