package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {".//Features//registration.feature"},
//        features = {".//Features//Login.feature"},
        //features = {".//Features//DataDrivenLogin.feature"},
        features = {".//Features//DataDrivenLoginWithExcel.feature"},
        glue = "stepDefinitions",
        plugin = {
                "pretty","html:reports/myreports.html",
                "json:reports/myreport.json"
        },
        dryRun = false,
        monochrome = true
//        tags = "@Regression" and "@Sanity"
)
public class TestRunner {
}
