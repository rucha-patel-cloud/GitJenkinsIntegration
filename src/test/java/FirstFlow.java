import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Util;

public class FirstFlow extends BaseTest {
    Util lock = new Util(driver);

    @Test
    public void searchProduct() throws InterruptedException {

        WebElement search = driver.findElement(By.cssSelector(".search-keyword"));
        System.out.println("search found");
        //lock.implicitWait();
        Thread.sleep(5000);
        search.sendKeys("tomato");
        //lock.implicitWait();
        Thread.sleep(2000);
    }

    @Test
    public void addProduct() throws InterruptedException {

        driver.findElement(By.cssSelector("div[class='product-action'] button[type='button']")).click();
        //lock.implicitWait();
        Thread.sleep(2000);
    }


}
