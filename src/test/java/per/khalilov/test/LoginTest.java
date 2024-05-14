package per.khalilov.test;

import per.khalilov.model.AccountData;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        manager.goTo().homePage();
        AccountData user = new AccountData("Bulat147", "147258369Hb");
        manager.manageAccount().loginUser(user);
        manager.goTo().userProfile();
        manager.manageAccount().logoutUser();
    }

}
