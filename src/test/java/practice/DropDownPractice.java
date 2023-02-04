package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class DropDownPractice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }


    @Test
    public void test1(){

        driver.get("https://practice.cydeo.com/dropdown");

        Select select = new Select(driver.findElement(By.xpath("//select[@id = 'dropdown']")));
        select.getOptions();
    }
}
