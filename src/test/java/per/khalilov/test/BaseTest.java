package per.khalilov.test;

import per.khalilov.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected ApplicationManager manager = new ApplicationManager();

    @Before
    public void setUp() {
        manager.setUp();
    }

    @After
    public void tearDown() {
        manager.tearDown();
    }

}
