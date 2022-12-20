package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{
    private final String BASE_URL = "https://www.zara.com/by/";
    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,driver);
    }
    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public boolean getLogged()
    {
        return true;
    }
}
