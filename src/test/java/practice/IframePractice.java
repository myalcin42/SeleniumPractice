package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class IframePractice {

    public WebDriver driver;


    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }


    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        driver.switchTo().frame(0);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'mce_0_ifr']")));

        driver.switchTo().parentFrame();
      //  driver.switchTo().defaultContent();


    }
}
