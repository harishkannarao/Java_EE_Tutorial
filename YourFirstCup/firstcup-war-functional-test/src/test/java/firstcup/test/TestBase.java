package firstcup.test;

import org.jboss.weld.environment.se.Weld;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestBase {

    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    private static WebDriver driver = null;
    
    private static Weld weld = null;

    protected String getAppServerUrl() {
        return System.getProperty("appServerUrl", "http://localhost:8080");
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void initializeWebDriver() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void closeWebDriver() {
        driver.quit();
    }
    
    @BeforeClass
    public static void startWeldContainer() {
        weld = new Weld();
        weld.initialize();
    }
    
    @AfterClass
    public static void stopWeldContainer() {
        weld.shutdown();
    }

}
