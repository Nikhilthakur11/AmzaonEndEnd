package testing.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testing.test.loginPage;

import testing.test.ExcelUtils;
import testing.test.Properetyfile;

public class LoginSteps{
	
	//WebDriver driver;
	//WebdriverSingleton web=new WebdriverSingleton();
	Properetyfile pro=new Properetyfile();
	PageObjectManager pom=PageObjectManager.getInstanceOfSingletonBrowserClass();
	
	//JsonDataReader jr=new JsonDataReader();
	//Page page=new BasePage(driver);
	ExcelUtils exceldata=new ExcelUtils();
	public List<HashMap<String, String>> dataSet;
	
	public LoginSteps(){
	//dataSet = ExcelUtils.readExcelDatafromFile();
	}
	loginPage lp=new loginPage(pom.getDriver());
	
	
	
	@Test(priority=1)
	public void user_is_on_HomePage() throws Exception  {
		System.out.println("in test");
		pom.getDriver();
		String actualTitle;
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in] but found [Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
			//pro=pom.getproperties();
		//driver.get(pro.getApplicationUrl());
		//System.setProperty("webdriver.chrome.driver",pro.getDriverPath());
        //driver = new ChromeDriver();
		//driver.get("https://www.amazon.in");
		//driver.manage().window().maximize();
		//actualTitle=driver.getTitle();
		//System.out.println(actualTitle)	;
		//Assert.assertEquals(expected, actualTitle);
		//lp.click_Login();
		//lp.enter_email_continue();
		//System.out.println("In prod Search page");
		
		  //lp.search_product();
	}

	

/*@Test(priority=2,dataProvider ="excel-data",dependsOnMethods="user_is_on_HomePage")*/
	@Test(priority=2)
	public void user_search_the(String product) throws Exception {
	
		//int dataRow = Integer.parseInt(excelDataRow)-1;
	
		System.out.println("In prod Search page");
	
	  lp.search_product("perfumes");
	}
/*@Test(priority=1)
	
	public void users_Login_to_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}*/
@Test(priority=3)
	
	public void select_set_wet_deodrant() throws Throwable {
	    lp.select_product();
	}


@Test(priority=4)
	public void click_on_add_to_cart_button() throws Throwable {
	   // lp.addToCart();
	    //lp.enter_email_continue();
		lp.addToCart();
	
		
	}

@Test(priority=5,dataProvider ="excel-data")
	//public void proceed_to_buy_with(String arg1) throws Throwable {
		public void proceed_to_buy(String phonenum,String password ) throws Throwable {
			Thread.sleep(5000);
		    lp.proceedToBuy();
		    //int dataRow = Integer.parseInt(excelDataRow)-1;
		    
		    lp.enter_email_continue(phonenum,password);
		    Thread.sleep(25000);
		}
	//@And("^proceed to buy with \"([^\"]*)\" and \"([^\"]*)\"$")
	
	
@Test(priority=6)
	public void add_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lp.selectDeleiveryAddress();
	}

@Test(priority=7)
	public void choose_delivery_options() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		lp.select_payment();
	}

@Test(priority=8)
	public void select_payment_mode() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

@Test(priority=9)
	public void review_your_order_and_place_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		lp.review_order();
		
	}

@Test(priority=10)
	public void add_the_credentials_to_sbi() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    lp.select_sbi();
	}


}
