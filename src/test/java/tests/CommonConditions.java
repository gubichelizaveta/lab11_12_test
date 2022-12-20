package tests;


import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup()
    {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
    }
//    @AfterMethod(alwaysRun = true)
//    public void stopBrowser()
//    {
//        DriverSingleton.closeDriver();
//    }
}
