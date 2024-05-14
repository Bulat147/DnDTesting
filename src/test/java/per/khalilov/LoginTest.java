package per.khalilov;

import per.khalilov.model.AccountData;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        openHomePage();
        AccountData user = new AccountData("Bulat147", "147258369Hb");
        loginUser(user);
        openUserProfile();
        logoutUser();
    }

}
