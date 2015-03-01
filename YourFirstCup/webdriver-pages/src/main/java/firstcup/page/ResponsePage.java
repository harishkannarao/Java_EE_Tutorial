package firstcup.page;

import org.openqa.selenium.By;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponsePage extends PageBase{

    private static final String PAGE_URL = "response.xhtml";
    private static final String PAGE_ID = "qa-response";

    private static final Pattern AVERAGE_AGE_DIFF_PATTERN = Pattern.compile("^The average age difference of all First Cup users is (.*)\\.$");

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
    
    public Optional<Float> getAverageAgeDifference() {
        String message = getAverageAgeDifferenceMessage();
        Matcher m = AVERAGE_AGE_DIFF_PATTERN.matcher(message);
        if (m.find()) {
            String avgAgeDiffStr = m.group(1);
            return Optional.of(Float.parseFloat(avgAgeDiffStr));
        } else {
            return Optional.empty();
        }
        
    }

    public void clickBackButton() {
        driver.findElement(By.id("response_form:back")).click();
    }
}
