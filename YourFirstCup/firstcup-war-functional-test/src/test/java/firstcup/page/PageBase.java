package firstcup.page;

import org.openqa.selenium.WebDriver;

public abstract class PageBase {

    protected abstract WebDriver getDriver();
    protected abstract String getAppUrl();
    protected abstract String getPageUrl();

    public void navigate() {
        getDriver().get(getAppUrl() + getPageUrl());
    }
}
