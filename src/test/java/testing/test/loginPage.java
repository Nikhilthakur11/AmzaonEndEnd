package testing.test;

import java.nio.file.Watchable;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.ls.LSInput;

import PredefinedMethods.ActionsMethods;
import PredefinedMethods.JavascriptExecutors;
import PredefinedMethods.SelectElementByType;
import PredefinedMethods.Windowhandles;
//import PredefinedMethods.JavascriptExecutor;
import testing.test.LoginSteps;
import testing.test.PageObjectManager;
//import gherkin.lexer.Pa;

import org.openqa.selenium.interactions.Actions;

import testing.test.ExcelUtils;

////import com.Filpkart.Shopping.PageElements;

import testing.test.LoggerHelper;
//import testDataTypes.Product;

public class loginPage{
	//WebDriver driver;
	Actions action;
	PageObjectManager pom=PageObjectManager.getInstanceOfSingletonBrowserClass();
	//	LoggerHelper
 //Logger log = LoggerHelper.getLogger(loginPage.class);
 static Logger log = Logger.getLogger(loginPage.class.getName());
	
	ExcelUtils excel=new ExcelUtils();
	 
	@FindBy(xpath="//span[@ID='nav-link-accountList-nav-line-1']")
	private static WebElement mousehover_signin; 
	
	//@FindBy(xpath="//div[1][@class='_39M2dM']/input")
	//public static WebElement loginID;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']/preceding-sibling::a")
	private static WebElement SignIn;  
	
	
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement email; 
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement sigcontinue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement sigpassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signinclcik;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private  WebElement searchprod; 
	@FindBy(xpath="//span[contains(text(),'Set Wet Deodorant Spray Perfume')]")
	private  WebElement selectprod;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private  WebElement clicksearch; 
	
	@FindBy(xpath="//div[@id='nav-flyout-searchAjax']']")
	private  WebElement searchtable; 
	
	@FindBy(xpath="//div[@id='issDiv3']/span[text()=' for men']")
	private  WebElement selectproduct_searchtable; 
	
	
	@FindBy(xpath="//a[@id='wishListMainButton-announce']")
	private  WebElement addtolist; 
	
	@FindBy(xpath="//a[@id='buybox-see-all-buying-choices-announce']")
	private  WebElement buyoptionsbutton; 
	
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private  WebElement addtocart; 
	
	@FindBy(xpath="//span[@id='hlb-ptc-btn']/span/a[contains(text(),'Proceed to Buy')]")
	private  WebElement proceedtobuy;
	
	@FindBy(xpath="//a[contains(text(),'Deliver to this address')]")
	private  WebElement selectdeleiveryaddress;
	
	@FindBy(xpath="//form[@id='shippingOptionFormId']/div/div[2]/div/span[@class='sosp-continue-button a-button a-button-primary a-button-span12 a-padding-none  continue-button ']")
	private  WebElement continue_choosedelivery;
	
	@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	private  WebElement selectNetbanking;
	
	@FindBy(xpath="//div[@class='a-box a-spacing-none pmts-instrument-box pmts-portal-component pmts-portal-components-pp-368fDv-18 pmts-selected']/div/div/div/div[2]/div[2]/div/div/div/span")
	private  WebElement chooseoptions;
	
	@FindBy(xpath="//div[@class='a-column a-span3 pmts-sidebar-wrapper a-span-last']/div/div/div/span/span")
	private  WebElement con_paymentmethod;
	
	@FindBy(xpath="//span[@id='placeYourOrder']/span/input[@name='placeYourOrder1']")
	private  WebElement placeyourorder;
	
	@FindBy(xpath="//input[@name='userName']")
	private  WebElement sbi_uname;
	
	@FindBy(xpath="//h4[text()='Incorrect phone number']")
	private WebElement erromsg_phonenumber;
	
	@FindBy(xpath="//li/span")
	private WebElement erromsg_password;
	
	@FindBy(xpath="//div[@id='auth-email-missing-alert']/div/div[@class='a-alert-content']")
	private WebElement erromsg_emptyphone;
	
	@FindBy(xpath="//div[@id='auth-password-missing-alert']/div/div")
			private WebElement erromsg_emptypassword;
	
	public loginPage(WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	public  void click_Login() throws Exception{
		
		log.info("in mousehover done");
		 ActionsMethods.mouseHover(mousehover_signin);
		SignIn.click();
		}
	
	public void enter_email_continue(String phnum,String password){
		//log.info(pass);
		try{
		email.sendKeys(phnum);
		sigcontinue.click();
		if(erromsg_phonenumber.isDisplayed()){
			String errormsg_phonenm=erromsg_phonenumber.getText();
			String exp_errormsg_phonenm="Incorrect Phone Number";
			if(errormsg_phonenm.equalsIgnoreCase("Incorrect Phone Number"))
				//log.info("No account with the provided number:"+errormsg_phonenm);
				System.out.println("No account with the provided number:"+errormsg_phonenm);
		}			
		
		if(erromsg_emptyphone.isDisplayed()){
			String errormsg_emptyphone=erromsg_emptyphone.getText();
			String exp_errormsg_emptyphone="Enter your email or mobile phone number";
			if(errormsg_emptyphone.contains("Enter your email or mobile phone number"))
				//log.info("empty phone number:"+erromsg_emptyphone);
				System.out.println("empty phone number:"+erromsg_emptyphone);
			}
		}
	
		catch(Exception e){
			
			
			e.printStackTrace();
			//you can add the driver.close if the step fails here
		}
		
		
		try{
		sigpassword.sendKeys(password);
		}
		catch(Exception e){
			if(erromsg_password.isDisplayed()){
			String errormsgs_password=erromsg_password.getText();
			String exp_errormsg_password="Your password is incorrect";
			if(errormsgs_password.equalsIgnoreCase("Your password is incorrect"))
				//log.info("No account with the provided password:"+errormsgs_password);	
				log.info("No account with the provided password:"+errormsgs_password);
			}
			if(erromsg_emptypassword.isDisplayed()){
			String errormsg_emptypass=erromsg_emptypassword.getText();
			String exp_errormsg_emptyphone="Enter your password";
			if(errormsg_emptypass.equalsIgnoreCase("Enter your password"))
				//log.info("empty password:"+errormsg_emptypass);
				//No account with the provided password:"+errormsgs_password
				log.info("No account with the provided password:"+errormsg_emptypass);
			}
			else
			e.printStackTrace();
			//you can add the driver.close if the step fails here
		}
	
		signinclcik.click();
		//buyoptionsbutton.click();
		//password.sendKeys(pass);	
	}
	public void search_product(String product) throws Exception{
		try{
		searchprod.sendKeys(product);
		//log.debug("enetering product");
		//errormsg_emptypass
		log.debug("enetering product");
		}
		catch(Exception e){
			//System.out.println("The product search was not available in amazon");
			log.debug("The product search was not available in amazon");
		}
		
			Thread.sleep(10000);
		
		
		/*WebElement selectpro=pom.getDriver().findElement(By.xpath("//span[contains(text(),'Organza By Givenchy For Women. Eau De Parfu')]"));
		JavascriptExecutor js=(JavascriptExecutor)pom.getDriver();
		js.executescript("arguments[0].scrollIntoView(true);", pom.getDriver().findElement(By.xpath("//span[contains(text(),'Organza By Givenchy For Women. Eau De Parfu')]")););
	*/}
		//waitForElement(cancel);
		//Thread.sleep(5000);
		//System.out.println(pr);
		//search.sendKeys(pr);
	
	/*public void filldetails(Product pro) throws Exception{
		log.debug("enetering product"+pro);
		click_cancel(pro.product);
	}*/



public void select_product() throws Exception {
	// TODO Auto-generated method stub
	List<WebElement> listofproductsearch=pom.getDriver().findElements(By.xpath("//div[@id='nav-flyout-searchAjax']/div/div/div[contains(@id,'issDiv')]"));
	for(int i=0;i<listofproductsearch.size();i++){
		try{
		if(listofproductsearch.get(i).getText().contains("for men")){
		listofproductsearch.get(i).click();
			break;//break the loop else you get stale element excpetion
		}
		}
		catch(Exception e){
		e.printStackTrace();
		}}
	//clicksearch.click();
	Thread.sleep(10000);
	
	try{
	JavascriptExecutors.scrollbyElement(selectprod);
	}
	catch(Exception e){
		e.printStackTrace();
	}
		Thread.sleep(10000);
	try{
	selectprod.click();	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	public void addToCart() throws Exception{
		try{
		Windowhandles.windowHandle();
		Thread.sleep(5000);
		addtocart.click();}
		catch(Exception e){
			e.printStackTrace();
		}
		//addtolist.click();
		
	}
	
	public void proceedToBuy() throws Exception{
		Thread.sleep(8000);
		try{
		proceedtobuy.click();}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	;
	public void selectDeleiveryAddress() throws Exception{
		Thread.sleep(5000);
		selectdeleiveryaddress.click();
		Thread.sleep(8000);
		continue_choosedelivery.click();
		Thread.sleep(5000);
	}
	
	public void select_payment() throws InterruptedException{
		Thread.sleep(5000);
		selectNetbanking.click();

		Thread.sleep(5000);
		chooseoptions.click();
		Thread.sleep(5000);
		SelectElementByType.SelectElementByText("State Bank of India", chooseoptions);
		Thread.sleep(5000);
		con_paymentmethod.click();
		
	}
public void review_order(){
	placeyourorder.click();
}
public void select_sbi(){
	sbi_uname.sendKeys("test");
	
}
}
