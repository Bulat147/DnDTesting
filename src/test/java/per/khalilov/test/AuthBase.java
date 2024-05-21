package per.khalilov.test;

import org.junit.Before;
import per.khalilov.model.AccountData;
import per.khalilov.util.Settings;

public class AuthBase extends BaseTest {

    @Override
    public void setUp() {
        super.setUp();
        AccountData user = new AccountData(Settings.username, Settings.password);
        manager.manageAccount().loginUser(user);
    }
}
