package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyTitle {

    public static void verifyTitle(WebDriver driver,String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}
