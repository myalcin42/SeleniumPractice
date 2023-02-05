package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class InterviewPractice {

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getPropertyCustom("interview.url"));

        WebElement cookiesAcceptButton = Driver.getDriver().findElement(By.cssSelector("input#sp-cc-accept"));

        cookiesAcceptButton.click();

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));

        searchBox.sendKeys("iPhone13 512" + Keys.ENTER);

        WebElement searchResults = Driver.getDriver().findElement(By.xpath("(//div[@class = 'a-section a-spacing-none'])[5]"));

       // System.out.println(searchResults.getText());

        Assert.assertTrue(searchResults.isDisplayed());

        Thread.sleep(2000);
        WebElement firstIphone = Driver.getDriver().findElement(By.xpath("//img[@class = 's-image']"));

        firstIphone.click();




    }
}
