package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Day10Task4Practice {

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get("https://practice.cydeo.com/");

        WebElement poweredByCydeoText = Driver.getDriver().findElement(By.xpath("(//div//div//div)[5]/div"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(poweredByCydeoText).perform();

        Thread.sleep(2000);

        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);
    }

}
