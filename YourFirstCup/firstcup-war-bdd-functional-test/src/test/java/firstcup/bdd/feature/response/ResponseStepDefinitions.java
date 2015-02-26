package firstcup.bdd.feature.response;

import cucumber.api.java.en.Then;
import firstcup.bdd.model.AgeDifferenceInfo;
import firstcup.bdd.util.CalendarUtil;
import firstcup.page.ResponsePage;
import firstcup.producer.qualifier.AppUrl;
import firstcup.producer.qualifier.TestSupportContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Then("^The average age difference should be displayed")
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
}
