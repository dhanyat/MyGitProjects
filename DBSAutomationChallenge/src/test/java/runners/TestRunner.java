package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
features = "src/test/resources/functionalTests",
glue = {"stepDefinitions"},
junit = "--step-notifications",
strict = true,
plugin = { "pretty", "html:target/cucumber-reports",
		             "json:target/cucumber.json"},
monochrome = true
		
)


public class TestRunner {
	

}
