package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalcPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTests {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static CalcPage calcPage;


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
    }

    @BeforeEach
    public void setup() {
        driver.get("http://google.com");
    }

    @Test
    @DisplayName("Задание 1: Расчет (1 + 2) × 3 - 40 ÷ 5") //Отображение названия теста
    public void test1() {
        searchPage.search("Калькулятор");
        calcPage = new CalcPage(driver);
        calcPage.openBracket.click();
        calcPage.oneButton.click();
        calcPage.plusButton.click();
        calcPage.twoButton.click();
        calcPage.closeBracket.click();
        calcPage.multButton.click();
        calcPage.threeButton.click();
        calcPage.minusButton.click();
        calcPage.fourButton.click();
        calcPage.zeroButton.click();
        calcPage.splitButton.click();
        calcPage.fiveButton.click();
        calcPage.equalsButton.click();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =",calcPage.memoryPane.getText());
        assertEquals("1",calcPage.resultPane.getText());
    }

    @Test
    @DisplayName("Задание 2: Расчет 6 ÷ 0") //Отображение названия теста
    public void test2() {
        searchPage.search("Калькулятор");
        calcPage = new CalcPage(driver);
        calcPage.sixButton.click();
        calcPage.splitButton.click();
        calcPage.zeroButton.click();
        calcPage.equalsButton.click();
        assertEquals("6 ÷ 0 =",calcPage.memoryPane.getText());
        assertEquals("Infinity",calcPage.resultPane.getText());
    }

    @Test
    @DisplayName("Задание 3: Расчет sin()") //Отображение названия теста
    public void test3() {
        searchPage.search("Калькулятор");
        calcPage = new CalcPage(driver);
        calcPage.sinButton.click();
        calcPage.equalsButton.click();
        assertEquals("sin() =", calcPage.memoryPane.getText());
        assertEquals("Error", calcPage.resultPane.getText());
    }

    @AfterAll
    public static void teardown() { driver.quit();
    }
}
