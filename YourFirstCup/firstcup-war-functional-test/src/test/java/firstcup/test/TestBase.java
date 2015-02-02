package firstcup.test;

import org.jboss.weld.environment.se.Weld;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public abstract class TestBase {

    // Create a new instance of the Firefox driver
    // Notice that the remainder of the code relies on the interface,
    // not the implementation.
    private static WebDriver driver = null;
    
    private static Weld weld = null;

    private static final String DRIVER_KEY = "driver";
    private static final String HTML_UNIT_DRIVER = "htmlunit";
    private static final String FIREFOX_DRIVER = "firefox";

    private static final String APP_SERVER_KEY = "appServerUrl";
    private static final String DEFAULT_APP_SERVER_VALUE = "http://localhost:8080";


    protected String getAppServerUrl() {
        return System.getProperty(APP_SERVER_KEY, DEFAULT_APP_SERVER_VALUE);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void initializeWebDriver() {
        String driverType = System.getProperty(DRIVER_KEY, HTML_UNIT_DRIVER);
        if (HTML_UNIT_DRIVER.equals(driverType)) {
            driver = new HtmlUnitDriver(true);
        } else if (FIREFOX_DRIVER.equals(driverType)) {
            driver = new FirefoxDriver();
        }
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
