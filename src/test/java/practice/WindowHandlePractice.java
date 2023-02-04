package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.Set;

public class WindowHandlePractice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }


    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/windows");

        WebElement clickHereButton = driver.findElement(By.xpath("//a[. = 'Click Here']"));
        clickHereButton.click();

        String windowHandle = driver.getWindowHandle();
     //  System.out.println("windowHandle = " + windowHandle);
     //   System.out.println(driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        for (String eachHandle : windowHandles) {

            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());

        }

        driver.switchTo().window(windowHandle);
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

}
