package per.khalilov.test;

import org.junit.AfterClass;
import org.junit.runners.Parameterized;
import per.khalilov.ApplicationManager;
import org.junit.Before;

import static java.lang.Thread.sleep;

@Parameterized.UseParametersRunnerFactory
public class BaseTest {

    protected ApplicationManager manager;

    @Before
    public void setUp() {
        manager = ApplicationManager.getInstance();
        manager.goTo().homePage();
    }

    public static void sleepWithTime(Long millis) {
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
