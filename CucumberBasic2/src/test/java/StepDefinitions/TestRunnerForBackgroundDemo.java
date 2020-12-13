package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Backgrounddemo/Backgrounddemo.feature", glue = {
		"stepsforBackground" }, monochrome = true, plugin = { "pretty", "html:target/HtmlReports/HtmlReports",
				"json:target/JSONReports/report.json", "junit:target/JUnitReports/report.xml" })
public class TestRunnerForBackgroundDemo {

}
