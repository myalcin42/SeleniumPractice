package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class TestCase6ContactUs {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }

    @Test
    public void test1(){

        String env = ConfigurationReader.getPropertyCustom("url");
        driver.get(env);

        WebElement contactUsButton = driver.findElement(By.xpath("//i[@class = 'fa fa-envelope']/.."));
        contactUsButton.click();

        String actual = driver.findElement(By.xpath("//h2[. = 'Get In Touch']")).getText();

        System.out.println(actual);
    }
}
