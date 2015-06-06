package firstcup.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty","json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },
        features="src/test/resources",
        glue = "firstcup.bdd"
)
public class RunCucumberIT {
}
