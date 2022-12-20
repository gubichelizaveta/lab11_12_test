package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JacketPage extends  AbstractPage{

    private final String PAGE_URL = "https://www.zara.com/by/en/woman-jackets-l1114.html?v1=2113434";

    public JacketPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,driver);
    }
    @Override
    public JacketPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        WebElement link = driver.findElement(By.xpath("//*[@id=\"theme-app\"]/div/div/header/div[1]/div[2]/section/nav/div/div/ul/li[2]/a"));
        link.click();
        return this;
    }
    public JacketPage SetUpFilters()
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
        return this;
    }
}
