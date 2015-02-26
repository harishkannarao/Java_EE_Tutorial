package firstcup.bdd.feature.response;

import cucumber.api.java.en.Then;
import firstcup.bdd.CalendarUtil;
import firstcup.bdd.model.AgeDifferenceInfo;
import firstcup.page.ResponsePage;
import firstcup.producer.qualifier.AppUrl;
import firstcup.producer.qualifier.TestSupportContext;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ResponseStepDefinitions {

    @Inject
    private ResponsePage responsePage;
    
    @Inject
    private CalendarUtil calendarUtil;

    @Inject
    @AppUrl
    private String appUrl;

    @Inject
    @TestSupportContext
    private String testSupportContext;
    
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    @Then("^Message should be displayed as (.*)$")
    public void message_should_be_displayed_as(String expectedMessage) throws Throwable {
        String actualMessage = responsePage.getAgeDifferenceMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("^The average age difference should be calculated based on (.*)$")
    public void The_average_age_difference_should_be_displayed(String dateOfBirth) throws Throwable {
        /*AgeDifferenceInfo ageDifferenceInfo = getAgeDifferenceFromDb();
        Date userDob = SIMPLE_DATE_FORMAT.parse(dateOfBirth);
        Calendar userDobCalender = new GregorianCalendar();
        userDobCalender.setTime(userDob);
        int userAgeDifference = calendarUtil.calculateAgeDifference(calendarUtil.getDukesBirthday(), userDobCalender);
*/
    }

    private AgeDifferenceInfo getAgeDifferenceFromDb() {
        Client client = ClientBuilder.newClient();
        WebTarget target
                = client.target(appUrl + "/" + testSupportContext + "/dbSupport/getAgeDifferenceInfo");
        return target.request().get(AgeDifferenceInfo.class);
    }
}
