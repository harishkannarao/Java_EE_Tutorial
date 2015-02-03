package firstcup.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResponsePage extends PageBase{

    private static final String PAGE_URL = "response.xhtml";

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    public String getAgeDifferenceMessage() {
        return driver.findElement(By.id("msgAgeDiff")).getText();
    }

    public String getAverageAgeDifferenceMessage() {
        return driver.findElement(By.id("msgAvgAgeDiff")).getText();
    }
}
