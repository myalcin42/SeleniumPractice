package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WebDriverFactory;

public class IframePractice {

    @Test
    public void test1(){

        Driver.getDriver().get(ConfigurationReader.getPropertyCustom("practice.url"));

        Driver.getDriver().findElement(By.xpath("//a[text() = 'Frames']")).click();

        Driver.getDriver().findElement(By.linkText("Nested Frames")).click();

        Driver.getDriver().switchTo().frame("frame-top");

        Driver.getDriver().switchTo().frame("frame-left");

        WebElement left = Driver.getDriver().findElement(By.xpath("//body[normalize-space(text()) = 'LEFT']"));

        System.out.println(left.getText());

        Driver.getDriver().switchTo().defaultContent();
    }


    }

