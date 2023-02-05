package practice;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ReviewPractice {

    @Test
    public void test1(){

        Driver.getDriver().get(ConfigurationReader.getPropertyCustom("practice.url"));
    }
}
