import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        driver.get("https://dnd.su/");
        driver.manage().window().maximize();
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).sendKeys("Bulat147");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("147258369Hb");
        driver.findElement(By.cssSelector(".col-9 > .btn")).click();
        driver.findElement(By.cssSelector(".item_level_1:nth-child(7) .item_level_2:nth-child(4) .item_text")).click();
        driver.get("https://dnd.su/");
        driver.findElement(By.cssSelector(".item_level_1:nth-child(7) .item_level_2:nth-child(5) .item_text")).click();
    }
}
