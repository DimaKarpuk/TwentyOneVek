package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.CategoryPage;

public class CategoryTest extends TestBase {
    CategoryPage categoryPage = new CategoryPage();
    @DisplayName("Тест кликабельности категории на главной странице")
    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Тест кликабельности категории {0} на главной странице")
    void choiceCategoryTest(String testData, String expectedValue){
        categoryPage.categorySelect(testData);
        categoryPage.checkExpectedValue(expectedValue);
    }
}
