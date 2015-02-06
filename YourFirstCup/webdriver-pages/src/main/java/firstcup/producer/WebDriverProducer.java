package firstcup.producer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class WebDriverProducer {

    private static final String DRIVER_KEY = "driver";
    private static final String HTML_UNIT_DRIVER = "htmlunit";
    private static final String FIREFOX_DRIVER = "firefox";

    @Produces
    @ApplicationScoped
    public WebDriver createWebDriver() {
        WebDriver driver = null;
        String driverType = System.getProperty(DRIVER_KEY, HTML_UNIT_DRIVER);
        if (HTML_UNIT_DRIVER.equals(driverType)) {
            driver = new HtmlUnitDriver(true);
        } else if (FIREFOX_DRIVER.equals(driverType)) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void closeWebDriver(@Disposes WebDriver driver) {
        driver.quit();
    }
}
