package testing.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


	
public class Screenshot {
	//WebDriver driver;
	

	//static  WebdriverSingleton web=new WebdriverSingleton();
	
	public static void takeScreenshotAtEndOfTest(WebDriver driver,String methodname) throws IOException{
		try{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File(currentDir + "/FailedScreenshots/" +methodname +System.currentTimeMillis() + ".png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}}
			
	public static void takeScreenshotAtEndOfTest(WebDriver driver){
			try{
				DateFormat dateFormat = new SimpleDateFormat(
						"dd_MMM_yyyy__hh_mm_ssaa");
				Date date = new Date();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" +"completed" +System.currentTimeMillis()+ ".png"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}	
			public static String takeScreenshotAtEndOfTest_Extent(WebDriver driver,String methodname){
				String currentDir = null;
				try{
					DateFormat dateFormat = new SimpleDateFormat(
							"dd_MMM_yyyy__hh_mm_ssaa");
					Date date = new Date();
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				 currentDir = System.getProperty("user.dir")+ "/screenshots/" +"completed" +System.currentTimeMillis()+ ".png";
				File destination=new File(currentDir);
				FileHandler.copy(scrFile, destination);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//String currentDir;
				//return currentDir;
				return currentDir;
			
}}
