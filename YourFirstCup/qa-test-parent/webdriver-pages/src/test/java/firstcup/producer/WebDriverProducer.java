package firstcup.producer;

import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class WebDriverProducer {

    private static final String DRIVER_KEY = "driver";
    private static final String HTML_UNIT_DRIVER = "htmlunit";
    private static final String HTML_UNIT_DRIVER_IGNORE_JS_ERROR = "htmlunit_ignore_js_error";
    private static final String FIREFOX_DRIVER = "firefox";

    private final WebDriver driver;

    public WebDriverProducer() {
        driver = createWebDriver();
        Runtime.getRuntime().addShutdownHook(new Thread("WebDriver shutdown thread") {
            public void run() {
                driver.quit();
            }
        });
    }

    @Produces
    @ApplicationScoped
    public WebDriver getWebDriver() {
        return driver;
    }

    public WebDriver createWebDriver() {
        WebDriver driver = null;
        String driverType = System.getProperty(DRIVER_KEY, HTML_UNIT_DRIVER);
        if (HTML_UNIT_DRIVER.equals(driverType)) {
            driver = new HtmlUnitDriver(true);
        } else if(HTML_UNIT_DRIVER_IGNORE_JS_ERROR.equals(driverType)) {
            driver = new HtmlUnitDriver(true){
                protected WebClient modifyWebClient(WebClient client) {
                    client.getOptions().setThrowExceptionOnScriptError(false);
                    return client;
                }
            };
        } else if (FIREFOX_DRIVER.equals(driverType)) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
