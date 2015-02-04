package firstcup.test;

import firstcup.page.GreetingPage;
import firstcup.page.HomePage;
import firstcup.page.ResponsePage;
import firstcup.runner.WeldJUnit4Runner;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

//@RunWith(WeldJUnit4Runner.class)
public class DukesAgeComparisonTest {

/*    @Inject
    private HomePage homePage;
    @Inject
    private GreetingPage greetingPage;
    @Inject
    private ResponsePage responsePage;*/

/*    @Test
    public void shouldCalculateAgeDifferenceAndAverageAgeDifference() {
        // navigate to home page
        homePage.navigate();

        // greetings page will be displayed
        // set the birthday
        greetingPage.setBirthday("09/10/2012");
        // submit the value
        greetingPage.clickSubmit();

        // response page will be displayed
        // get the age difference message
        String ageDiffMsg = responsePage.getAgeDifferenceMessage();
        assertEquals("You are 17 years younger than Duke!", ageDiffMsg);

        // get the average age difference message
        String avgAgeDiffMsg = responsePage.getAverageAgeDifferenceMessage();
        assertEquals("The average age difference of all First Cup users is -17.0.", avgAgeDiffMsg);
    }*/


}
