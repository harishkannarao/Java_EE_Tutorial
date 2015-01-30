package firstcup.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResponsePage extends PageBase{

    private final WebDriver driver;
    private final String appUrl;
    private static final String PAGE_URL = "/firstcup-war/response.xhtml";

    public ResponsePage(WebDriver driver, String appUrl) {
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

    public String getAgeDifferenceMessage() {
        return getDriver().findElement(By.id("msgAgeDiff")).getText();
    }

    public String getAverageAgeDifferenceMessage() {
        return getDriver().findElement(By.id("msgAvgAgeDiff")).getText();
    }
}
