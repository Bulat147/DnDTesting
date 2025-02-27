package per.khalilov;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import per.khalilov.helper.LoginHelper;
import per.khalilov.helper.MagicItemHelper;
import per.khalilov.helper.NavigationHelper;
import per.khalilov.util.Settings;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();
    public WebDriver driver;
    String baseUrl;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private LoginHelper loginHelper;
    private MagicItemHelper magicItemHelper;
    private NavigationHelper navigationHelper;

    private ApplicationManager() {}

    public static ApplicationManager getInstance() {
        ApplicationManager manager;
        if (app.get() == null) {
            app.set(new ApplicationManager());
            manager = app.get();
            manager.setUp();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                manager.driver.quit();
            }));
        } else {
            manager = app.get();
        }
        return manager;
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        baseUrl = Settings.baseUrl;
        loginHelper = new LoginHelper(this);
        magicItemHelper = new MagicItemHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public LoginHelper manageAccount() {
        return loginHelper;
    }

    public MagicItemHelper magicItem() {
        return magicItemHelper;
    }

}
