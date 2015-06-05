package firstcup.bdd.feature.response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import firstcup.bdd.model.AgeDifferenceInfo;
import firstcup.bdd.util.CalendarUtil;
import firstcup.page.ResponsePage;
import firstcup.producer.qualifier.AppUrl;
import firstcup.producer.qualifier.TestSupportContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Singleton
public class ResponseStepDefinitions {

    private ResponsePage responsePage;
    private CalendarUtil calendarUtil;
    private String appUrl;
    private String testSupportContext;
    
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    @Inject
    public ResponseStepDefinitions(ResponsePage responsePage, CalendarUtil calendarUtil, @AppUrl String appUrl, @TestSupportContext String testSupportContext) {
        this.responsePage = responsePage;
        this.calendarUtil = calendarUtil;
        this.appUrl = appUrl;
        this.testSupportContext = testSupportContext;
    }

    @Then("^Message should be displayed as (.*)$")
    public void message_should_be_displayed_as(String expectedMessage) throws Throwable {
        String actualMessage = responsePage.getAgeDifferenceMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("^The average age difference should be displayed$")
    public void The_average_age_difference_should_be_displayed() throws Throwable {
        AgeDifferenceInfo ageDifferenceInfo = getAgeDifferenceFromDb();
        float expectedAverageAgeDifference = Float.valueOf(ageDifferenceInfo.getTotalAgeDifference())/Float.valueOf(ageDifferenceInfo.getTotalCount());
        Optional<Float> actualAverageAgeDifference = responsePage.getAverageAgeDifference();
        assertTrue("Should get average age difference", actualAverageAgeDifference.isPresent());
        assertEquals("Incorrect average age difference", expectedAverageAgeDifference, actualAverageAgeDifference.get().floatValue(), 0.0f);
    }

    private AgeDifferenceInfo getAgeDifferenceFromDb() {
        ClientConfig cc = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(cc);
        WebTarget target
                = client.target(appUrl + "/" + testSupportContext + "/dbSupport/getAgeDifferenceInfo");
        return target.request().get(AgeDifferenceInfo.class);
    }

    @Then("^The average age difference should be displayed as (.*)$")
    public void The_average_age_difference_should_be_displayed_as(float expectedAvgAgeDiff) throws Throwable {
        Optional<Float> actualAverageAgeDifference = responsePage.getAverageAgeDifference();
        assertTrue("Should get average age difference", actualAverageAgeDifference.isPresent());
        assertEquals("Incorrect average age difference", expectedAvgAgeDiff, actualAverageAgeDifference.get().floatValue(), 0.0f);

    }

    @When("^I click back button on response page$")
    public void I_click_back_button_on_response_page() throws Throwable {
        responsePage.clickBackButton();
    }
}
