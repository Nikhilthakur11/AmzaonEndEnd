package PredefinedMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testing.test.PageObjectManager;
import testing.test.Properetyfile;

public class JavascriptExecutors {
	static Properetyfile pro=new Properetyfile();
	static JavascriptExecutor js;
	 //static Actions action;
static  PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
	
	public static void scrollbyElement(WebElement ele){
		js=(JavascriptExecutor)po.getDriver();
	js.executeScript("arguments[0].scrollIntoView(true);", ele);
		//js.scrollbyElement(ele);
		
}

	
}