package Tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GooglTest1 {

    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximazed");
        options.addArguments("--user-data-dir=C:\\Users\\Bjoerndalen\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        options.addArguments("--profile-directory=Profile 1");
        driver = new ChromeDriver(options);
        driver.get("http://google.com");
    }


    @Test
    public void test1() {
        driver.get("http://google.com");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("selenium", Keys.ENTER);
        assertEquals(9, driver.findElements(By.cssSelector("#search .g")).size());

    }
    @AfterAll
    public static void teardown() {
        driver.quit();
    }

}
