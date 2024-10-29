package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features/signup.feature", 
		dryRun = false,
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		glue = { "stepDefinitions" }, 	
		plugin = { "pretty", "html:target/cucumber-reports.html" }, 
		monochrome = true 
)

public class TestNGRunner extends AbstractTestNGCucumberTests {
	
}
