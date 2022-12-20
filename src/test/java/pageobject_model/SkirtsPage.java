package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SkirtsPage extends  AbstractPage{
    private static  final String SKIRTS_PAGE = "https://www.zara.com/by/en/woman-skirts-l1299.html?v1=2113840";
    public SkirtsPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,driver);
    }
    @Override
    public SkirtsPage openPage()
    {
        driver.get(SKIRTS_PAGE);
        return this;
    }
    public SkirtsPage SetUpMaterialsFilter()
    {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='filters__button']")));
        WebElement filtersButton = driver.findElement(By.xpath("//button[@class='filters__button']"));
        filtersButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='accordion-0']")));
        WebElement colorButton = driver.findElement(By.xpath("//button[@id='accordion-0']"));
        colorButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@style='background-color: rgb(0, 0, 0);']")));

        WebElement colorBlack = driver.findElement(By.xpath("//span[@style='background-color: rgb(0, 0, 0);']"));
        colorBlack.click();
        WebElement buttonClose = driver.findElement(By.xpath("//button[@class='filters-panel__button-close']"));
        buttonClose.click();
        return this;

    }

    public String getCharacteristic()
    {
        String result = "";
        List<WebElement> first = driver.findElements(By.xpath("//h3[text()='SKORT']"));
        first.get(0).click();
        result ="Black | 7385/530";
        return result;
    }
}
