package testing.test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.mongodb.diagnostics.logging.Logger;

import bsh.This;

public class Annotationstest extends Hooks {
	
	Annotationstest(){
		DOMConfigurator.configure("log4j.xml");
		System.out.println("constructor in");
	}
	public static Logger Logg = Logger.getLogger(Annotationstest.class);
//LoggerHelper logg=new LoggerHelper();
	//adding comments
	Properetyfile pro=new Properetyfile();
	PageObjectManager pom=PageObjectManager.getInstanceOfSingletonBrowserClass();
	loginPage lp=new loginPage(pom.getDriver());
	
	@Test(priority=1)
	public void test1(){
		
		LoggerHelper.startTestCase("annotation test");	
		//Logg.info("In start testcase");
		LoggerHelper.info("In start testcase" );
	}
	@Test(priority=2,dataProviderClass=DataProviders.class,dataProvider ="Products",alwaysRun= true)
	public void test2(String Prod) throws Exception{
		
		LoggerHelper.info("In prod Search page");
		
		//System.out.println("In prod Search page");
		
		  lp.search_product(Prod);
	}
	@Test(priority=3)
	public void test3() throws Exception{
		//System.out.println("tst2");
		lp.select_product();
	}
	
	@Test(priority=4)
	public void click_on_add_to_cart_button() throws Throwable {
	   // lp.addToCart();
	    //lp.enter_email_continue();
		lp.addToCart();
		
		//System.out.println("in cart done");
		LoggerHelper.info("in cart done");
		
		/*SoftAssert soft=new SoftAssert();
		soft.*/
		Thread.sleep(5000);
	    lp.proceedToBuy();
		
	}

	@Test(priority=5,dataProviderClass=DataProviders.class,dataProvider ="credentials",alwaysRun= true)
	//public void proceed_to_buy_with(String arg1) throws Throwable {
		public void proceed_to_buy(String phonenum,String password )  {
		LoggerHelper.info("in proceed to buy ");
			
		    //int dataRow = Integer.parseInt(excelDataRow)-1;
		    
		    lp.enter_email_continue(phonenum,password);
		    try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//@And("^proceed to buy with \"([^\"]*)\" and \"([^\"]*)\"$")
	
	
@Test(priority=6)
	public void add_address() {
	    // Write code here that turns the phrase above into concrete actions
	//System.out.println("in addd addrress");
	LoggerHelper.info("in add address done");
		try {
			lp.selectDeleiveryAddress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	    LoggerHelper.endTestCase(this.getClass().getCanonicalName());
	}



}
