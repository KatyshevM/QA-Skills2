package Tests;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GooglTest1 {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage detailsPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximazed");
        options.addArguments("--user-data-dir=C:\\Users\\Bjoerndalen\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        options.addArguments("--profile-directory=Profile 1");
        driver = new ChromeDriver(options);
        driver.get("http://google.com");
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    @BeforeEach
    public void setup(){
        driver.get("http://google.com");
    }

    @Test
    @DisplayName("Поиск числа резултатов") //Отображение названия теста
    public void test1() {
        searchPage.search("selenium");
        assertEquals(9, searchPage.results.size());
    }

    @Test
    @DisplayName("Проверка деталей ресурса") //Отображение названия теста
    public void test2() {
        searchPage.search("selenium");
        assertAll(
                () -> assertEquals("Selenium", detailsPage.getName()),
                () -> assertEquals("3.141.59 (14 ноября 2018 года)", detailsPage.getLasVersion()),
                () -> assertEquals("Apache License 2.0", detailsPage.getLicense())
        );
    }

    @AfterAll
    public static void teardown() { driver.quit();
    }


}
