package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class ConfigPractice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");

        driver = WebDriverFactory.getDriver(browserType);



    }

    @Test
    public void test1(){

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));

        searchBox.sendKeys("apple" + Keys.ENTER);

        String expectedResult = "1-16 of over 100,000 results for \"apple\"";

        String actualResult = driver.findElement(By.xpath("//span[. = '1-16 of over 100,000 results for']/..")).getText();

        Assert.assertTrue(actualResult.equals(expectedResult));



    }
}
