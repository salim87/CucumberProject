package runner_files;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//path of feature file
		   features = {"classpath:Features"},
		   //path of step definition file
		   glue = "cucumber_selenium",
		dryRun = false
		  // tags="@tag1"
		)
public class cucumberRunnerTest {

}
