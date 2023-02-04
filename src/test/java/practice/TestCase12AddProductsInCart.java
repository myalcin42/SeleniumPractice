package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

public class TestCase12AddProductsInCart {

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

        WebElement productsButton = driver.findElement(By.xpath("//i[@class = 'material-icons card_travel']/.."));
        productsButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Removing the all google ads in the HTML by JavaScript
        js.executeScript("const arr = document.querySelectorAll('.adsbygoogle'); " +
                "arr.forEach(e => e.remove());");

        //Clicking again because navigating to the page has stopped.
        productsButton.click();

        WebElement addtoCartLink = driver.findElement(By.xpath("(//i[@class = 'fa fa-shopping-cart']/..)[2]"));

        js.executeScript("arguments[0].scrollIntoView();", addtoCartLink);

        WebElement firstProduct = driver.findElement(By.xpath("//img[@src = '/get_product_picture/1']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(firstProduct).pause(2000).perform();

        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class = 'btn btn-default add-to-cart']"));
        actions.moveToElement(addToCartButton).pause(2000).click().perform();




    }
}
