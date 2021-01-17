package PredefinedMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import testing.test.PageObjectManager;
import testing.test.Properetyfile;

/*import Pages.DriverUtil;
import TestSteps.PageObjectManager;
import other.Properetyfile;
*/
public class ActionsMethods {
	 static Properetyfile pro=new Properetyfile();
	 static Actions action;
	static PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
	//WebDriver driver;
	
	public static void mouseHover(WebElement element){
		action = new Actions(po.getDriver());
		   action.moveToElement(element)
		            .build().perform();
		//ActionsMethods.mouseHover(mousehover_signin, driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

}}
