package firstcup.test;

import firstcup.producer.qualifier.AppUrl;
import firstcup.runner.WeldJUnit4Runner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

@RunWith(WeldJUnit4Runner.class)
public abstract class TestBase {

    @Inject
    protected WebDriver driver;
    @Inject
    @AppUrl
    private String appServerUrl;

    protected String getAppServerUrl() {
        return appServerUrl;
    }

}
