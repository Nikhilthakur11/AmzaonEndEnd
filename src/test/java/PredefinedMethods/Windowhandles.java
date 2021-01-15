package PredefinedMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import testing.test.PageObjectManager;
import testing.test.Properetyfile;

public class Windowhandles {
	static Properetyfile pro=new Properetyfile();
	//static JavascriptExecutor js;
	 //static Actions action;
static  PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
	
	public static void windowHandle(){
		
		// It will return the parent window name as a String
		String parent=po.getDriver().getWindowHandle();

		Set<String>s=po.getDriver().getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
			po.getDriver().switchTo().window(child_window);

		System.out.println(po.getDriver().switchTo().window(child_window).getTitle());

		//po.getDriver().close();
		}

		}
	}

}
