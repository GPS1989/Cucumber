package SD;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue={"SD"},
monochrome=true,
plugin={"pretty","junit:target/JunitReports/REPORTS.xml",
		"json:target/JsonReports/REPORT.json",
		"html:target/HTMLREPORTS"},
		tags="@smoketest")
public class RunnerC {

}
 