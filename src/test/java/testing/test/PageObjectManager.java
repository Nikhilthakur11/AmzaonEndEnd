package testing.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.internal.Version;

//import other.Properetyfile;

public class PageObjectManager {
	
	// instance of singleton class
	private static PageObjectManager instanceOfSingletonBrowserClass=null;
	Properetyfile prop=new Properetyfile();
	
    private WebDriver driver;

    // Constructor
    @SuppressWarnings("deprecation")
	private PageObjectManager(){
    	DesiredCapabilities capabilities =DesiredCapabilities.chrome();

    	capabilities.setCapability("browser_version","65");
    	System.setProperty("webdriver.chrome.driver",prop.getDriverPath());
    	System.out.println("the broweser driver got it");
		driver= new ChromeDriver();
		driver.get(prop.getApplicationUrl());
		
		driver.manage().window().maximize();
    }

    // TO create instance of class
    public static PageObjectManager getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
        	instanceOfSingletonBrowserClass = new PageObjectManager();
        }
        return instanceOfSingletonBrowserClass;
    }
    
    // To get driver
    public WebDriver getDriver()
    {
    	return driver;
    }
    

   


}
