package firstcup.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreetingPage extends PageBase{
    private final WebDriver driver;
    private final String appUrl;
    private static final String PAGE_URL = "/firstcup-war/greeting.xhtml";

    public GreetingPage(WebDriver driver, String appUrl) {
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

    public void setBirthday(String birthday) {
        // get input date element by id
        WebElement element = this.driver.findElement(By.id("inputForm:userBirthday:getdate"));
        element.sendKeys(birthday);
    }

    public void clickSubmit() {
        this.driver.findElement(By.id("inputForm:submit")).click();
    }
}
