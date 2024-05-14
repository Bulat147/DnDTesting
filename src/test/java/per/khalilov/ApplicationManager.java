package per.khalilov;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import per.khalilov.helper.LoginHelper;
import per.khalilov.helper.MagicItemHelper;
import per.khalilov.helper.NavigationHelper;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {

    public WebDriver driver;
    String baseUrl;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private LoginHelper loginHelper;
    private MagicItemHelper magicItemHelper;
    private NavigationHelper navigationHelper;

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        baseUrl = "https://dnd.su/";
        loginHelper = new LoginHelper(this);
        magicItemHelper = new MagicItemHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
    }

    public void tearDown() {
        driver.quit();
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
