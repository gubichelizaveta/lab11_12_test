package pageobject_model;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractPage{
    private final String PAGE_URL = "https://www.zara.com/by/en/logon";

    @FindBy(xpath = "//span[@value='Email']")
    private WebElement inputLogin;
    @FindBy(xpath = "//span[@value='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//span[@value='LOG IN']")
    private WebElement buttonLOGIN;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,driver);
    }
    @Override
    public LoginPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public MainPage login (User user)
    {
        WebElement inputpass = driver.findElement(By.xpath("//input[@class='form-input-label__input form-input-password__input']"));
        WebElement inputlog = driver.findElement(By.xpath("//input[@class='form-input-label__input form-input-text__input']"));
        WebElement btnlogin = driver.findElement(By.xpath("//div[@class='zds-button__lines-wrapper']"));
        inputlog.sendKeys(user.getUsername());
        inputpass.sendKeys(user.getPassword());
        btnlogin.click();
        return new MainPage(driver);
    }


}
