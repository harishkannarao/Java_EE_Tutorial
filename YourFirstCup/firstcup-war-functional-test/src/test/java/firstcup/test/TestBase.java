package firstcup.test;

import firstcup.runner.WeldJUnit4Runner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

@RunWith(WeldJUnit4Runner.class)
public abstract class TestBase {

    @Inject
    protected WebDriver driver;

    private static final String APP_SERVER_KEY = "appServerUrl";
    private static final String DEFAULT_APP_SERVER_VALUE = "http://localhost:8080";

    protected String getAppServerUrl() {
        return System.getProperty(APP_SERVER_KEY, DEFAULT_APP_SERVER_VALUE);
    }

}
