package practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.VerifyTitle;
import utilities.WebDriverFactory;

public class FirstTest {


    @Test
    public void main() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://google.com");

        VerifyTitle.verifyTitle(driver, "Google");




    }
}
