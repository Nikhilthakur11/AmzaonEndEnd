package PredefinedMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testing.test.PageObjectManager;
import testing.test.Properetyfile;

public class Waits {
	
public static void Expliciitwaitmode(WebElement ele){
	
	Properetyfile pro=new Properetyfile();
	PageObjectManager pom=PageObjectManager.getInstanceOfSingletonBrowserClass();
	
	
	WebDriverWait wait=new WebDriverWait(pom.getDriver(), 20);
	wait.until(ExpectedConditions.elementToBeSelected(ele));
	
}

}
