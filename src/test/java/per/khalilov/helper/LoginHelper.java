package per.khalilov.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import per.khalilov.ApplicationManager;
import per.khalilov.model.AccountData;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void loginUser(AccountData user) {
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".col-9 > .btn")).click();
    }

    public void logoutUser() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"aside\"]/nav/ul/li[7]/ul/li[5]/a"));
        element.sendKeys(Keys.PAGE_DOWN);
        element.click();
    }
}
