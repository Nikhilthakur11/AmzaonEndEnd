package testing.test;

import java.util.Properties;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Properetyfile{
    Properties prop;
    FileInputStream  reader;
    String filenames;
	
String file="application.properties";
 public Properetyfile(){
	 //filenames=filename;
	try {
		System.out.println("before property location");
		reader = new FileInputStream(file);
		System.out.println("after property location");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
     
	    //Properties p=new Properties();  
	    try {
	    	prop=new Properties();
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 /*FileReader file;
		try {
			
			file = new FileReader("F://HTC_START//Filpkart//Config//application.properties");
			System.out.println("file path");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //InputStream is = Properetyfile.class.getResourceAsStream("/application.properties");
		 //BufferedReader reader;
		 //reader = new BufferedReader(new InputStreamReader(is));
		 prop = new Properties();
		 try {
			 prop.load(file);
			 System.out.println("file loaded");
		 file.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } 
		 }*/
 }
	 public String getDriverPath(){
		 String driverPath = prop.getProperty("driverpath");
		 System.out.println(driverPath);
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
		 
		 public long getImplicitlyWait() { 
		 String implicitlyWait = prop.getProperty("implicitlyWait");
		 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
		 }
		 
		 public String getApplicationUrl() {
		 String url = prop.getProperty("url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }	
		 public String getBrowser() {
			 System.out.println("came to browser getrowser method");
			 String browserName = prop.getProperty("browser");
			 //String browserName = properties.getProperty("browser");
				if(browserName == null || browserName.equals("chrome")) return browserName;
				else if(browserName.equalsIgnoreCase("firefox")) return browserName;
				else if(browserName.equals("iexplorer")) return browserName;
				else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
			}	
		 /*public String getEnvironment() {
			 String environmentName = prop.getProperty("environment");
			 //String environmentName = properties.getProperty("environment");
				if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvType.LOCAL;
				else if(environmentName.equals("remote")) return EnvType.REMOTE;
				else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
			
			 }*/	
		 public Boolean getBrowserWindowSize() {
			 String windowSize = prop.getProperty("windowMaximize");
			 if(windowSize != null) return Boolean.valueOf(windowSize);
			 return true;
			 }
		 public String getTestDataResourcePath(){
			 String testDataResourcePath = prop.getProperty("testDataResourcePath");
			 if(testDataResourcePath!= null) return testDataResourcePath;
			 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
			}
		 public String getReportConfigPath(){
			 String reportConfigPath = prop.getProperty("reportConfigPath");
			 if(reportConfigPath!= null) return reportConfigPath;
			 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
			}
}
