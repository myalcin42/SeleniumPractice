package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.List;

public class Task3_FindElements {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }

    @Test
    public void test1(){

        driver.get("https://www.openxcell.com");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("allLinks size " + allLinks.size());

        Assert.assertEquals(allLinks.size(), "332");
    }

    @Test
    public void test2(){

        driver.get("https://www.openxcell.com");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement each : allLinks) {

            System.out.println(each.getText());
        }
    }

    @Test
    public void test3(){

        driver.get("https://www.openxcell.com");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        int count = 0;
        for (WebElement each : allLinks) {
            if(each.getText().isEmpty() || each.getText().isBlank()){
                count++;
            }
        }

        System.out.println("count = " + count);
    }
}
