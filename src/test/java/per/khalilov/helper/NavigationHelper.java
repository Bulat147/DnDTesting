package per.khalilov.helper;

import org.openqa.selenium.By;
import per.khalilov.ApplicationManager;

import static per.khalilov.test.BaseTest.sleepWithTime;

public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void userProfile() {
        driver.findElement(By.cssSelector(".item_level_1:nth-child(7) .item_level_2:nth-child(4) .item_text")).click();
    }

    public void workshopPage() {
        driver.findElement(By.xpath("//*[@id=\"aside\"]/nav/ul/li[7]/ul/li[2]/a/span[2]")).click();
    }

    public void homePage() {
        driver.get(baseUrl);
        sleepWithTime(1000L);
    }
}
