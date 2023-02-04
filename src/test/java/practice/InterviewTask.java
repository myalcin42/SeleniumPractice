package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class InterviewTask {

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get("https://todomvc.com/");

        WebElement polymer = Driver.getDriver().findElement(By.xpath("//a[@href = 'examples/polymer/index.html']"));

        polymer.click();

        WebElement todoBox = Driver.getDriver().findElement(By.cssSelector("#new-todo"));

        todoBox.sendKeys("first item" + Keys.ENTER);
        todoBox.sendKeys("second item" + Keys.ENTER);

        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(2000);

        WebElement secondItem = Driver.getDriver().findElement(By.xpath("//label[. = 'second item']"));

       actions.moveToElement(secondItem).doubleClick().perform();

        Thread.sleep(2000);

        WebElement edit = Driver.getDriver().findElement(By.cssSelector("#edit"));


        Thread.sleep(2000);





    }
}
