package firstcup.test;

import firstcup.page.GreetingPage;
import firstcup.page.HomePage;
import firstcup.page.ResponsePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class DukesAgeComparisonTest extends TestBase{

    @Test
    public void shouldCalculateAgeDifferenceAndAverageAgeDifference() {
        // navigate to home page
        HomePage homePage = new HomePage(driver, getAppServerUrl());
        homePage.navigate();

        // greetings page will be displayed
        GreetingPage greetingPage = new GreetingPage(driver, getAppServerUrl());
        // set the birthday
        greetingPage.setBirthday("09/10/2012");
        // submit the value
        greetingPage.clickSubmit();

        // response page will be displayed
        ResponsePage responsePage = new ResponsePage(driver, getAppServerUrl());
        // get the age difference message
        String ageDiffMsg = responsePage.getAgeDifferenceMessage();
        assertEquals("You are 17 years younger than Duke!", ageDiffMsg);
        // get the average age difference message
        String avgAgeDiffMsg = responsePage.getAverageAgeDifferenceMessage();
        assertEquals("The average age difference of all First Cup users is -17.0.", avgAgeDiffMsg);
    }


}
