import Utils.RestDriver;
import StepDefinitions.services.base.BaseService;
import StepDefinitions.services.comments.CommentsApi;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
		"html:target/cucumber-reports/cucumber.html",
		"json:target/cucumber-reports/cucumber.json"
}, features = "src/test/resources/features/", tags = "", glue = "StepDefinitions.services")
public class SuiteRunnerTest {

	private static Properties properties;
	private static RestDriver restDriver;
	private static BaseService baseService;
	private static Logger logger = LoggerFactory.getLogger(SuiteRunnerTest.class);


	@BeforeClass
	public static void init() throws IOException {

		logger.info("*****Starting init()*******");
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/testConfig.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		restDriver = new RestDriver(properties);
		baseService = new BaseService();
		baseService.setRestDriver(restDriver);
		baseService.setProperties(properties);

	}

	@AfterClass
	public static void tearDown() {
		logger.info("*****Entering final teardown() *******");
		baseService = null;
		properties = null;
		restDriver = null;
		logger=null;
	}


}
