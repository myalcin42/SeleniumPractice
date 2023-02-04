package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.SmartBearUtils;
import utilities.WebDriverFactory;

import java.util.List;

public class SmartBearPractice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        String browserType = ConfigurationReader.getPropertyCustom("browser");
        driver = WebDriverFactory.getDriver(browserType);
    }

    @Test
    public void test1(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginToSmartBear(driver, "Tester", "test");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links size is " + links.size());

        for (WebElement link : links) {
            System.out.println("link text " + link.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginToSmartBear(driver, "Tester", "test");

        WebElement orderLink = driver.findElement(By.xpath("//a[. = 'Order']"));

        orderLink.click();

        WebElement productDropdown = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));

        Select select = new Select(productDropdown);

        select.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));

        quantity.sendKeys(Keys.BACK_SPACE + "2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value = 'Calculate']"));

        Thread.sleep(2000);

        calculateButton.click();

        Faker faker = new Faker();

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().cityName());

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode());

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).click();

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5566778899865766");

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("01/24");

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton")).click();

        WebElement message = driver.findElement(By.xpath("//strong"));

        String expectedMessage = "New order has been successfully added.";
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage,expectedMessage);


    }

    @Test
    public void test3(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginToSmartBear(driver, "Tester", "test");

        WebElement orderDate = driver.findElement(By.xpath("//table[@class = 'SampleTable']/tbody/tr[6]//td[.='Susan McLaren']//following::td[3]"));

        String actualDate = orderDate.getText();
        System.out.println("orderDate = " + orderDate.getText());
        String expectedDate = "01/05/2010";

        Assert.assertEquals(actualDate, expectedDate);
    }
}
