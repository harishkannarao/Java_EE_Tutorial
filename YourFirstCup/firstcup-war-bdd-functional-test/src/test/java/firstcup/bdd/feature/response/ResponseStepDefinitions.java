package firstcup.bdd.feature.response;

import cucumber.api.java.en.Then;
import firstcup.page.ResponsePage;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

public class ResponseStepDefinitions {

    @Inject
    private ResponsePage responsePage;

    @Then("^Message should be displayed as (.*)$")
    public void message_should_be_displayed_as(String expectedMessage) throws Throwable{
        String actualMessage = responsePage.getAgeDifferenceMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
