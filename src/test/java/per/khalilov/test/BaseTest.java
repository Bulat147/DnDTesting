package per.khalilov.test;

import org.junit.AfterClass;
import per.khalilov.ApplicationManager;
import org.junit.Before;

import static java.lang.Thread.sleep;

public class BaseTest {

    protected ApplicationManager manager;

    @Before
    public void setUp() {
        manager = ApplicationManager.getInstance();
    }

    public static void sleepWithTime(Long millis) {
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void tearDown() {
        ApplicationManager.getInstance().tearDown();
    }

}
