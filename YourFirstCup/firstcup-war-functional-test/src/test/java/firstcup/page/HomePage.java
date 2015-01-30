package firstcup.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    private final WebDriver driver;
    private final String appUrl;
    private static final String PAGE_URL = "/firstcup-war";

    public HomePage(WebDriver driver, String appUrl) {
        this.driver = driver;
        this.appUrl = appUrl;
    }


    @Override
    protected WebDriver getDriver() {
        return this.driver;
    }

    @Override
    protected String getAppUrl() {
        return this.appUrl;
    }

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }
}
