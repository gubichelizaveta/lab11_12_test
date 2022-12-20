package pageobject_model;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class ZaraHomePage {
    private static final String HOMEPAGE_URL = "https://www.zara.com/by/";
    private static final String SEARCH_FINDER_URL = "https://www.zara.com/by/en/z-stores-st1404.html?v1=11108";
    private static  final String SKIRTS_PAGE = "https://www.zara.com/by/en/woman-skirts-l1299.html?v1=2113840";
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchBtnElement;
    @FindBy(id = "search-products-form-combo-input")
    private WebElement searchInputElement;
    @FindBy(xpath = "//button[@class='layout-header__mobile-action layout-header__mobile-action--menu']")
    private WebElement burgerMenu;

    public ZaraHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  ZaraHomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        searchBtnElement.click();
        return this;
    }
    public ZaraHomePage openStoresFinder()
    {
        driver.get(SEARCH_FINDER_URL);
        return this;
    }
    public ZaraHomePage SetRegion(String city)
    {
        WebElement text = driver.findElement(By.xpath("//input[@class='form-input-label__input form-input-text__input']"));
        text.sendKeys(city);
        return this;
    }
    public boolean ConfirmQueryForSearch()
    {
        WebElement button = driver.findElement(By.xpath("//button[@class='button location-search-form__submit']"));
        button.click();
        return true;
    }
    public String ChangeLng()
    {
        WebElement language = driver.findElement(By.xpath("//a[@class='layout-footer-link link']"));
        language.click();
        return "1";
    }
    public SkirtsPage openSkirtsPage()
    {
        driver.get(HOMEPAGE_URL);
        driver.get(SKIRTS_PAGE);
        return new SkirtsPage(driver);
    }
    public ZaraSearchResultPage searchForJeans(String str)
    {
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Search']")));
        searchInputElement.sendKeys(str);
        searchInputElement.sendKeys(Keys.ENTER);
        return new ZaraSearchResultPage(driver,str);
    }
}