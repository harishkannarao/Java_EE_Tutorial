package firstcup.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class DukesAgeComparisonTest extends TestBase{

    @Test
    public void shouldCalculateAgeDifferenceAndAverageAgeDifference() {
        // navigate to home page
        String homePage = getAppServerUrl() + "/firstcup-war";
        getDriver().get(homePage);

        // get input date element by id
        WebElement element = getDriver().findElement(By.id("inputForm:userBirthday:getdate"));

        // enter some valid values
        element.sendKeys("09/10/2012");

        // now submit the form. WebDriver will find the form for us from the element
        getDriver().findElement(By.id("inputForm:submit")).click();

        // get the html text
        String ageDiffMsg = getDriver().findElement(By.id("msgAgeDiff")).getText();
        assertEquals("You are 17 years younger than Duke!", ageDiffMsg);

        String avgAgeDiffMsg = getDriver().findElement(By.id("msgAvgAgeDiff")).getText();
        assertEquals("The average age difference of all First Cup users is -17.0.", avgAgeDiffMsg);
    }


}
