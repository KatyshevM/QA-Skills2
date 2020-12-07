package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;


public class CalcPage {

    //поиск 1
    @FindBy(css = "div[jsname='N10B9']")
    public WebElement oneButton;

    //поиск 2
    @FindBy(css = "div[jsname='lVjWed']")
    public WebElement twoButton;

    //поиск 3
    @FindBy(css = "div[jsname='KN1kY']")
    public WebElement threeButton;

    //поиск 4
    @FindBy(css = "div[jsname='xAP7E']")
    public WebElement fourButton;

    //поиск 5
    @FindBy(css = "div[jsname='Ax5wH']")
    public WebElement fiveButton;

    //поиск 6
    @FindBy(css = "div[jsname='abcgof']")
    public WebElement sixButton;

    //поиск 0
    @FindBy(css = "div[jsname='bkEvMb']")
    public WebElement zeroButton;

    //поиск Открывающаяся скобка
    @FindBy(css = "div[jsname='j93WEe']")
    public WebElement openBracket;

    //поиск Закрывающаяся скобка
    @FindBy(css = "div[jsname='qCp9A']")
    public WebElement closeBracket;

    //поиск Плюс
    @FindBy(css = "div[jsname='XSr6wc']")
    public WebElement plusButton;

    //поиск Минус
    @FindBy(css = "div[jsname='pPHzQc']")
    public WebElement minusButton;

    //поиск Умножение
    @FindBy(css = "div[jsname='YovRWb']")
    public WebElement multButton;

    //поиск Деление
    @FindBy(css = "div[jsname='WxTTNd']")
    public WebElement splitButton;

    //поиск Равно
    @FindBy(css = "div[jsname='Pt8tGc']")
    public WebElement equalsButton;

    //поиск Строки памяти
    @FindBy(css = "span[jsname='ubtiRe']")
    public WebElement memoryPane;

    //поиск Строки результата
    @FindBy(css = "span[jsname='VssY5c']")
    public WebElement resultPane;

    public CalcPage(WebDriver driver) {
        initElements(driver, this);

    }
}
