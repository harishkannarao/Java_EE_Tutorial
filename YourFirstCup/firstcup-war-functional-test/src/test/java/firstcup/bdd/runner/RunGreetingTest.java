package firstcup.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:firstcup/bdd/runner/greeting.feature"},
        strict = true,
        format = {"pretty","json:target/Cucumber.json", "html:target/cucumber-html-report"}
)
public class RunGreetingTest {
}
