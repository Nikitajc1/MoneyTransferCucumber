import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//import steps.TemplateSteps;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("src/test/java/resources/features")
//@ConfigurationParameter(key = "MoneyTransferCucumber", value = "java.steps")
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        features = {"src/test/resources/features"},
        glue = {"java.steps"})
public class RunCucumberTest {
}