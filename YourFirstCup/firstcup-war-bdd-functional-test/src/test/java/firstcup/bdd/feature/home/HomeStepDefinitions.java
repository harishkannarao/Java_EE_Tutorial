package firstcup.bdd.feature.home;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import firstcup.page.GreetingPage;
import firstcup.page.HomePage;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

public class HomeStepDefinitions {
    
    @Inject
    HomePage homePage;
    @Inject
    GreetingPage greetingPage;

    @Given("^I navigate to home page$")
    public void i_navigate_to_home_page() throws Throwable {
        homePage.navigate();
    }

    @Then("^I should see greeting page$")
    public void i_should_see_greeting_page() throws Throwable {
        assertTrue(greetingPage.isOnValidPage());
    }
}
