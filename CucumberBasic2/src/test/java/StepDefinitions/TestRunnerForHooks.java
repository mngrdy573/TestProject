package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/HooksFeature/Hooks.feature",glue= {"StepForHooks"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports/HtmlReports",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReports/report.xml"})

public class TestRunnerForHooks {

}
