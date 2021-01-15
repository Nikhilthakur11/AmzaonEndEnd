package PredefinedMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.Filpkart.Shopping.ShoppingHooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testing.test.PageObjectManager;
import testing.test.Screenshot;

public class TestListener2 implements ITestListener {
	
	PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();

	@SuppressWarnings("deprecation")
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onFinish(ITestContext arg0) {
		Screenshot.takeScreenshotAtEndOfTest(po.getDriver());
		extent.flush();
			}

	public void onStart(ITestContext arg0) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Nikhil");
		
		htmlReporter.config().setDocumentTitle("Amazon Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);

		

		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("TestFailedButWithinSuccessPercentage");
		
	}

	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		String methodName = tr.getName().toString().trim();
		String screenshotPath=System.getProperty("user.dir")+"\\FailedScreenshots\\"+tr.getName()+".png";
		
		//File f = new File(screenshotPath); 
		
		//if(f.exists())
		{
		/*try {
			//logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		logger.log(Status.FAIL, "snapshat below:"+logger.addScreencastFromPath(screenshotPath));
		System.out.println("took screenhsot and added to extent report");
		} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}*/
				try {
					String screenshotpath=Screenshot.takeScreenshotAtEndOfTest_Extent(po.getDriver(),methodName);
					logger.log(Status.FAIL, "snapshat below:"+logger.addScreencastFromPath(screenshotpath));
					logger.addScreenCaptureFromPath(screenshotpath);
					System.out.println("took screenhsot and added to extent report");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
	}

	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("test started");
		
	}

	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		String methodName = tr.getName().toString().trim();
		try {
			String screenshotpath=Screenshot.takeScreenshotAtEndOfTest_Extent(po.getDriver(),methodName);
			logger.log(Status.PASS, "snapshat below:"+logger.addScreencastFromPath(screenshotpath));
			logger.addScreenCaptureFromPath(screenshotpath);
			System.out.println("took screenhsot and added to extent report");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	
		


	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 * capture the screenshot of a page on failure
	 */
	
