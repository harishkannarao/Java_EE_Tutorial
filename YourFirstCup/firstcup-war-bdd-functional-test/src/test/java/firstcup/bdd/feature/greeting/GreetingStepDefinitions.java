package firstcup.bdd.feature.greeting;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import firstcup.page.GreetingPage;
import firstcup.page.ResponsePage;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class GreetingStepDefinitions {
    @Inject
    private GreetingPage greetingPage;

    @Given("^I am on greeting page$")
    public void i_am_on_greeting_page() throws Throwable{
        greetingPage.navigate();
        
    }
    
    @Then("^Dukes age should be displayed$")
    public void dukes_age_should_be_displayed() throws Throwable {
        assertEquals(expectedDukesAge(),greetingPage.getDukesAge());
    }
    
    @When("^I enter birthday as (.*)$")
    public void i_enter_birthday(String birthday) throws Throwable {
        greetingPage.setBirthday(birthday);
    }
    
    @When("^I click on submit$")
    public void i_click_on_submit() throws Throwable {
        greetingPage.clickSubmit();
    }

    private int expectedDukesAge() {
        // same logic as in Application
        Calendar dukesBirthday = getDukesBirthday();
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        return dukesAge;
    }

    private Calendar getDukesBirthday() {
        return new GregorianCalendar(1995, Calendar.MAY, 23);
    }
}
