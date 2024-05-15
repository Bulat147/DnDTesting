package per.khalilov.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import per.khalilov.ApplicationManager;
import per.khalilov.model.AccountData;

import static per.khalilov.test.BaseTest.sleepWithTime;

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
        WebElement element = driver.findElement(By.xpath("//span[text()=\"Выход\"]"));
        element.click();
    }
}
