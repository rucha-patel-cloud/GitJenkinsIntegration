package utils;


import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Util{

    WebDriver driver;
    public Util(WebDriver driver){
        this.driver = driver;
    }
    public Util(){

    }
    public void implicitWait(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



}
