package runner_files;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//path of feature file
		   features = {"classpath:Features/Login_Steps_wu.feature"},
		   //path of step definition file
		   glue = "cucumber_selenium",
		monochrome = true,

		dryRun = false
		  // tags="@tag1"
		)
public class cucumberRunnerTest {

}
