import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeClass
    public void goTo() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        // Thread.sleep(5000);

    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }


}
