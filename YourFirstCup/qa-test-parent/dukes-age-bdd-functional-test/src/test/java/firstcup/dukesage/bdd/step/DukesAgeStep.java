package firstcup.dukesage.bdd.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

@ApplicationScoped
public class DukesAgeStep {
    private Client client = ClientBuilder.newClient();
    private String url;
    private Response response;

    @Given("^Url as (.*)$")
    public void Url_as_dukes_age_webapi_dukesAge(String url) throws Throwable {
        this.url = url;
    }

    @When("^I make a GET request$")
    public void I_make_a_GET_request() throws Throwable {
        WebTarget target
                = client.target(getAppServerUrl() + this.url);
        response = target.request().get();
    }

    @Then("^Status should be (\\d+)$")
    public void Status_should_be(int status) throws Throwable {
        assertEquals(status, this.response.getStatus());
    }

    @And("^Should return correct dukes age$")
    public void Should_return_correct_dukes_age() throws Throwable {
        int expectedAge = calculateExpectedAge();
        int actualAge = Integer.parseInt(response.readEntity(String.class));
        assertEquals(expectedAge, actualAge);
    }

    private String getAppServerUrl() {
        return System.getProperty("appServerUrl", "http://localhost:8080");
    }

    private int calculateExpectedAge() {
        // same logic as in DukesAgeResource
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        return dukesAge;
    }
}
