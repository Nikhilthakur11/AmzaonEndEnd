package testing.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class Hooks {
	
	PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
	@BeforeClass
	public void Setup(){
		po.getDriver();
		
		
	}
	@AfterClass(alwaysRun=true)
	public void teardown(){
		Screenshot.takeScreenshotAtEndOfTest(po.getDriver());
		po.getDriver().quit();
	}

}
