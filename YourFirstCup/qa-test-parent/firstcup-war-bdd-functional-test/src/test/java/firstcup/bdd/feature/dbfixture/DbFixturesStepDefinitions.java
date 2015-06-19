package firstcup.bdd.feature.dbfixture;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import firstcup.producer.qualifier.AppUrl;
import firstcup.producer.qualifier.TestSupportContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

@ApplicationScoped
public class DbFixturesStepDefinitions {
    @Inject
    @AppUrl
    private String appUrl;

    @Inject
    @TestSupportContext
    private String testSupportContext;

    @And("^I reset the fixtures$")
    public void I_reset_the_fixtures() throws Throwable {
        ClientConfig cc = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(cc);
        WebTarget target = client.target(appUrl + "/" + testSupportContext + "/dbFixtures/reset");
        String result = target.request().get(String.class);
        assertEquals("Db fixtures reset failed", "Success!!!", result);
    }

    @When("^I clear the fixtures$")
    public void I_clear_the_fixtures() throws Throwable {
        ClientConfig cc = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(cc);
        WebTarget target = client.target(appUrl + "/" + testSupportContext + "/dbFixtures/clear");
        String result = target.request().get(String.class);
        assertEquals("Db fixtures clear failed", "Success!!!", result);
    }
}
