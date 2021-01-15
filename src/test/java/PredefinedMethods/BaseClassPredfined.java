package PredefinedMethods;

import org.openqa.selenium.WebDriver;

import Pages.DriverUtil;

public class BaseClassPredfined extends DriverUtil{
	
	public static WebDriver driver;
	
	public BaseClassPredfined(){
		this.driver=driver;
		
	}
	
	/*public BaseClassPredfined(WebDriver driver){
		this.driver=driver;
	}*/
	

}
