import Utils.RestDriver;
import StepDefinitions.services.base.BaseService;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
}, features = "src/test/features/", tags = "", glue = "StepDefinitions.services")
public class SuiteRunnerTest {

    private static Properties properties;
    private static RestDriver restDriver;
    private static BaseService baseService;


    @BeforeClass
    public static void init() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testConfig.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        restDriver = new RestDriver(properties);
        baseService = new BaseService();
        baseService.setRestDriver(restDriver);
        baseService.setProperties(properties);

    }

    @AfterClass
    public static void tearDown() {
        baseService = null;
        properties = null;
        restDriver = null;
    }


}
