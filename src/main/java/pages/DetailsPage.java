package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DetailsPage {

    //поиск последней версии Селениума в Гугл
    @FindBy(css = "#wp-tabs-container div[data-attrid*='webfacts:poslednyaya_versiya'] .LrzXr.kno-fv")
    private WebElement lastVersion;

    //поиск лицензии Селениума в Гугл
    @FindBy(css = "#wp-tabs-container div[data-attrid*='licenziya'] .LrzXr.kno-fv")
    private WebElement license;

    //поиск лицензии Селениума в Гугл
    @FindBy(css = "#wp-tabs-container h2[data-attrid*='title']")
    private WebElement name;

    public DetailsPage (WebDriver driver) {
        initElements(driver, this);
    }

    public String getName() {
        return name.getText();
    }

    public String getLasVersion() {
        return lastVersion.getText();
    }

    public String getLicense() {
        return license.getText();
    }


}
