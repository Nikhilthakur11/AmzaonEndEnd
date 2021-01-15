
package testing.test;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)
/*@CucumberOptions(
 features = "src/main/resources/Features",
 glue={"src/test/java/TestSteps"},		
//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentreport.html"},
 monochrome = true
 )*/
@CucumberOptions(
		features={"Features"},glue="TestSteps"
)



	public class TestRunnerClass {
	private TestNGCucumberRunner testNGCucumberRunner;  

	  @BeforeClass(alwaysRun = true)  
	    public void setUpClass() throws Exception {  
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
	  }  

	    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")  
	    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {  
	        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());  
	  }  

	    @DataProvider  
	  public Object[][] scenarios() {  
	        return testNGCucumberRunner.provideScenarios();  
	  }  

	    @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	        testNGCucumberRunner.finish();  
	  }  

	}

