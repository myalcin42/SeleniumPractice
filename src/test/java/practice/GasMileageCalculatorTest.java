package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class GasMileageCalculatorTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }

    @Test
    public void test1(){

        driver.get("https://www.calculator.net");

        WebElement searchBox = driver.findElement(By.cssSelector("#calcSearchTerm"));
        searchBox.sendKeys("gas mileage");

        driver.findElement(By.xpath("//a[. = 'Gas Mileage Calculator']")).click();

        Assert.assertEquals(driver.getTitle(), "Gas Mileage Calculator");

        Assert.assertTrue(driver.findElement(By.xpath("//h1[. = 'Gas Mileage Calculator']")).isDisplayed());

        WebElement currentOdometer = driver.findElement(By.xpath("//input[@id = 'mucodreading']"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        WebElement previousOdometer = driver.findElement(By.xpath("//input[@id = 'mupodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        WebElement gasAdded = driver.findElement(By.xpath("//input[@id = 'mugasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        WebElement gasPrice = driver.findElement(By.xpath("//input[@id = 'mugasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        WebElement calculateButton = driver.findElement(By.xpath("//table[@id='metric']//input[@value='Calculate']"));
        calculateButton.click();

    }
}
