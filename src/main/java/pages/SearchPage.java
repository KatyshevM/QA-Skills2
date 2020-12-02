package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {

    //локатор поисковой строки вГугл
    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement SearchInput;

    //локатор найденных элементов в Гугл
    @FindBy(css = "#search .g")
    public List<WebElement> results;


    //ввод Селениум в поисковой строке в Гугл
    public SearchPage(WebDriver driver) {
        initElements(driver, this);
    }


    public void search (String text) {
        SearchInput.sendKeys(text, Keys.ENTER);
    }
}
