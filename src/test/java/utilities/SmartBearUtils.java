package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver, String userName, String passWord){

        WebElement userNameText = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));

        WebElement passWordText = driver.findElement(By.xpath("//input[@type = 'password']"));

        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));

        userNameText.sendKeys(userName);
        passWordText.sendKeys(passWord);

        loginButton.click();

    }


}
