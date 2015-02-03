package firstcup.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreetingPage extends PageBase{

    private static final String PAGE_URL = "greeting.xhtml";
    private static final String PAGE_ID = "qa-greeting";

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    @Override
    protected String getPageId() {
        return PAGE_ID;
    }

    public void setBirthday(String birthday) {
        // get input date element by id
        WebElement element = driver.findElement(By.id("inputForm:userBirthday:getdate"));
        element.sendKeys(birthday);
    }

    public void clickSubmit() {
        driver.findElement(By.id("inputForm:submit")).click();
    }
}
