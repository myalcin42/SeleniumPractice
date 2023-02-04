package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.lang.module.Configuration;

public class JavaScriptPractice {

    @Test
    public void test(){

        Driver.getDriver().get(ConfigurationReader.getPropertyCustom("practice.url"));

        WebElement smallCircle = Driver.getDriver().findElement(By.cssSelector("div#draggable"));

        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[contains(@*, 'drop')]"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle, bigCircle).perform();




    }
}
