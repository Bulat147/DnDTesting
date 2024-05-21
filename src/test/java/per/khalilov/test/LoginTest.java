package per.khalilov.test;

import org.openqa.selenium.By;
import per.khalilov.model.AccountData;
import org.junit.Test;
import per.khalilov.util.Settings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidData() {
        AccountData user = new AccountData(Settings.username, Settings.password);

        manager.manageAccount().logoutUser();
        manager.manageAccount().loginUser(user);
        manager.goTo().userProfile();

        assertThat("",
                manager.manageAccount().getLoggedInUsername(),
                equalTo(user.getUsername())
        );
    }

    @Test
    public void testLoginWithInvalidData() {
        AccountData user = new AccountData("Burbur", "43757834gb");

        manager.manageAccount().logoutUser();
        manager.manageAccount().loginUser(user);

        assertThat("",
                manager.driver.findElement(By.cssSelector("#body > div.alert-stack > div > div > span.alert-text")).isDisplayed(),
                equalTo(true)
        );
    }



}
