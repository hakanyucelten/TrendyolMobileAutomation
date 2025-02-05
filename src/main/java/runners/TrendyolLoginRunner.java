package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import util.DriverFactory;

@CucumberOptions(
        features = "src/test/java/features",
        tags = "@TrendyolAutomation",
        glue = {"stepDefs"},
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/index.html" },
        monochrome = true
)
public class TrendyolLoginRunner extends AbstractTestNGCucumberTests {

    @Parameters("platform")
    @BeforeTest
    public void setUp(String platform) {
        // Pass platform parameter to DriverFactory
        DriverFactory.setPlatform(platform);
    }
}