package firstcup.page;

import org.openqa.selenium.By;

public class ResponsePage extends PageBase{

    private static final String PAGE_URL = "response.xhtml";
    private static final String PAGE_ID = "qa-response";

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    @Override
    protected String getPageId() {
        return PAGE_ID;
    }

    public String getAgeDifferenceMessage() {
        return driver.findElement(By.id("msgAgeDiff")).getText();
    }

    public String getAverageAgeDifferenceMessage() {
        return driver.findElement(By.id("msgAvgAgeDiff")).getText();
    }
}
