package PredefinedMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.Filpkart.Shopping.WebdriverSingleton;

import TestSteps.PageObjectManager;
import other.Properetyfile;

public class SelectElementByType {
	static Properetyfile pro=new Properetyfile();
	//static JavascriptExecutor js;
	 //static Actions action;
static  PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
static Select select;
	
	
	public static void SelectElementByText(String text,WebElement ele) throws InterruptedException {
		select=new Select(ele);
		Thread.sleep(5000);
		select.selectByVisibleText(text);
		Thread.sleep(5000);
	}

	/**
	 * Method to select element 'by' type
	 * 
	 * @param type
	 *            : String : 'By' type
	 * @param access_name
	 *            : String : Locator value
	 * @return By
	 */
	public By getelementbytype(String type, String access_name) {
		switch (type) {
		case "id":
			return By.id(access_name);
		case "name":
			return By.name(access_name);
		case "class":
			return By.className(access_name);
		case "xpath":
			return By.xpath(access_name);
		case "css":
			return By.cssSelector(access_name);
		case "linkText":
			return By.linkText(access_name);
		case "partialLinkText":
			return By.partialLinkText(access_name);
		case "tagName":
			return By.tagName(access_name);
		default:
			return null;

		}
	}}
