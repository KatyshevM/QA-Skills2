package Tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Поиск числа резултатов") //Отображение названия теста
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

}
