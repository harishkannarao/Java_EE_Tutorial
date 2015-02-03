package firstcup.page;

import firstcup.producer.qualifier.AppContext;
import firstcup.producer.qualifier.AppUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

public abstract class PageBase {

    @Inject
    protected WebDriver driver;
    @Inject
    @AppUrl
    protected String appUrl;
    @Inject
    @AppContext
    protected String appContext;
    protected static final String PATH_SEPERATOR = "/";

    protected abstract String getPageUrl();

    protected abstract String getPageId();

    public void navigate() {
        driver.get(appUrl + PATH_SEPERATOR + appContext + PATH_SEPERATOR + getPageUrl());
    }

    public boolean isOnValidPage() {
        return driver.findElement((By.id(getPageId()))).isEnabled();
    }
}
