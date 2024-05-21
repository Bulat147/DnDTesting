package per.khalilov.test;

import org.junit.Before;
import per.khalilov.model.AccountData;

public class AuthBase extends BaseTest {

    @Override
    public void setUp() {
        super.setUp();
        AccountData user = new AccountData("B147258", "147258369Hb");
        manager.manageAccount().loginUser(user);
    }
}
