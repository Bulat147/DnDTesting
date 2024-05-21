package per.khalilov.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import per.khalilov.ApplicationManager;
import per.khalilov.model.AccountData;

import java.util.Objects;

import static per.khalilov.test.BaseTest.sleepWithTime;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void loginUser(AccountData user) {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getUsername())) {
                return;
            }
            logoutUser();
        }
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(user.getUsername());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".col-9 > .btn")).click();
    }

    public void logoutUser() {
        if (isLoggedIn()) {
            driver.findElement(By.xpath("//span[text()=\"Выход\"]")).click();
        }
    }

    public boolean isLoggedIn() {
        try {
            driver.findElement(By.cssSelector("#aside > nav > ul > li:nth-child(7) > ul > li:nth-child(4) > a > span.item_text"));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        manager.goTo().userProfile();
        return Objects.equals(getLoggedInUsername(), username);
    }

    public String getLoggedInUsername() {
        return driver.findElement(By.cssSelector("#body > main > div > div > div > section.block.block_100 > div > div > div > div > div.profile-text > div.profile-text__top-line > div > a")).getText();
    }

}
