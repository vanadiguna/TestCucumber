package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features\\login.feature","Features\\Customer.feature"},
        glue = "stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"}  //For Test Report
)
public class TestRunner {
}
