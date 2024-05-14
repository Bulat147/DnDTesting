package per.khalilov;

import org.openqa.selenium.*;
import per.khalilov.model.AccountData;
import per.khalilov.model.MagicItemData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    String baseUrl = "https://dnd.su/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public void loginUser(AccountData user) {
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".col-9 > .btn")).click();
    }

    public void openUserProfile() {
        driver.findElement(By.cssSelector(".item_level_1:nth-child(7) .item_level_2:nth-child(4) .item_text")).click();
    }

    public void openWorkshopPage() {
        driver.findElement(By.xpath("//*[@id=\"aside\"]/nav/ul/li[7]/ul/li[2]/a/span[2]")).click();
    }

    public void logoutUser() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"aside\"]/nav/ul/li[7]/ul/li[5]/a"));
        element.sendKeys(Keys.PAGE_DOWN);
        element.click();
    }

    public void createMagicItem(MagicItemData magicItem) {
        openWorkshopPage();
        driver.findElement(By.cssSelector("li:nth-child(7) .btn")).click();
        if (magicItem.getTitle() != null) {
            driver.findElement(By.name("title")).click();
            driver.findElement(By.name("title")).sendKeys(magicItem.getTitle());
        }
        if (magicItem.getTitleEn() != null) {
            driver.findElement(By.name("title_en")).click();
            driver.findElement(By.name("title_en")).sendKeys(magicItem.getTitleEn());
        }
        if (magicItem.getType() != null) {
            driver.findElement(By.name("type")).click();
            driver.findElement(By.cssSelector(".active .if-list__item:nth-child(" + magicItem.getType().index + ") > .if-list__item-title")).click();
        }
        if (magicItem.getSubtype() != null) {
            driver.findElement(By.name("subtype")).click();
            driver.findElement(By.name("subtype")).sendKeys(magicItem.getSubtype());
        }
        if (magicItem.getPrice() != null) {
            driver.findElement(By.name("price")).click();
            driver.findElement(By.name("price")).sendKeys(magicItem.getPrice());
        }
        if (magicItem.getQuality() != null) {
            driver.findElement(By.name("quality")).click();
            driver.findElement(By.cssSelector(".active .if-list__item:nth-child(" + magicItem.getQuality().index + ") > .if-list__item-title")).click();
        }
        if (magicItem.getSubquality() != null) {
            driver.findElement(By.name("subquality")).click();
            driver.findElement(By.name("subquality")).sendKeys(magicItem.getSubquality());
        }
        driver.findElement(By.xpath("//*[@id=\"editor_block\"]/div/div/div[2]/form/div/div[12]/input")).click();
        if (magicItem.getDescription() != null) {
            driver.findElement(By.cssSelector(".trumbowyg-editor")).click();
            {
                driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(magicItem.getDescription());
            }
        }
        driver.findElement(By.xpath("//*[@id=\"editor_block\"]/div/div/div[2]/form/div/div[12]/input")).click();
    }

}
