import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Testing {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.drive","C:\\chrome\\chromedriver-win32");
        driver =  new ChromeDriver() ;
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void testGooglePage(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Youtube");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Youtube - Buscar con Google",driver.getTitle());

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
