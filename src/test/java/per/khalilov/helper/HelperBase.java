package per.khalilov.helper;

import org.openqa.selenium.WebDriver;
import per.khalilov.ApplicationManager;

public class HelperBase {

    protected WebDriver driver;
    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
    }
}
