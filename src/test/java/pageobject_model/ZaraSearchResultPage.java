package pageobject_model;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ZaraSearchResultPage {
    private WebDriver driver;
    private String str;

    @FindBy(xpath = "//span[1][@class='money-amount__main']")
    private WebElement element;
    @FindBy(xpath = "//span[@class='money-amount__main']")
    private List<WebElement> searchResultsElement;

    public ZaraSearchResultPage(WebDriver driver,String str)
    {
        this.driver = driver;
        this.str = str;
        PageFactory.initElements(driver,str);
    }
    public int CountSearchResults()
    {
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[1][@class='money-amount__main']")));
        List<WebElement> searchResultsList = driver
                .findElements(By.xpath("//span[@class='money-amount__main']"));
        return searchResultsList.size();
    }
}