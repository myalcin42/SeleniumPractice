package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class TestCase1AutomationExerciseWebsite {

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

        WebElement signUpButton = driver.findElement(By.xpath("//i[@class = 'fa fa-lock']/.."));

        signUpButton.click();

       Assert.assertTrue(driver.findElement(By.xpath("//h2[. = 'New User Signup!']")).isDisplayed());

       driver.findElement(By.xpath("//input[@data-qa = 'signup-name']")).sendKeys("munir kara");

       driver.findElement(By.xpath("//input[@data-qa = 'signup-email']")).sendKeys("gocagonyaligroup12@gmail.com");

       WebElement signUpButton1 = driver.findElement(By.xpath("//button[@data-qa = 'signup-button']"));
       signUpButton1.click();

       Assert.assertTrue(driver.findElement(By.xpath("//b[text() = 'Enter Account Information']")).isDisplayed());

       driver.findElement(By.xpath("//input[@id = 'newsletter']")).click();




    }
}
