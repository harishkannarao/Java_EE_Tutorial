package firstcup.bdd.feature.greeting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        format = {
                "pretty","json:target/Cucumber.json", 
                "html:target/cucumber-html-report"
        }
)
public class RunGreetingTest {
}
