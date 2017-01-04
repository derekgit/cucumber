package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by elquiff on 02/01/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions
        (
                plugin = {"pretty", "html:target/cucumber","json:target/Destination/cucumber.json"},
                features = ("src/test/java/features"),//string
                glue = "Stepdefs",//package
                tags = {"@runthis" , "~@ignore"}
        )

public class runTest {
//left blank this does not require anything for cucumber to run
}
