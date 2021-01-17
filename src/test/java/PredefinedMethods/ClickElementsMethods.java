package PredefinedMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testing.test.PageObjectManager;

public class ClickElementsMethods extends SelectElementByType  {
	private WebElement element = null;
	
	WebDriverWait wait=new WebDriverWait(po.getDriver(), 20);
	static  PageObjectManager po=PageObjectManager.getInstanceOfSingletonBrowserClass();
	//WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds)

	/**
	 * Method to click on an element
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void click(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();
	}

	/**
	 * Method to forcefully click on an element
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void clickForcefully(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor) po.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method to Double click on an element
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 */
	public void doubleClick(String accessType, String accessValue) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));

		Actions action = new Actions(po.getDriver());
		action.moveToElement(element).doubleClick().perform();
	}
	public void waitForElementToDisplay(String accessType, String accessName, String duration) {
		By byEle = getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(po.getDriver(), Integer.parseInt(duration) * 1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
	}
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return po.getDriver().getTitle();
	}
	/**getPageTitle
	 * Method to Explicitly wait for element to be enabled=click
	 * 
	 * @param accessType
	 *            : String : Locator type (id, name, class, xpath, css)
	 * @param accessName
	 *            : String : Locator value
	 * @param duration
	 *            : String : Time to wait for element to be clickable
	 */
	public void waitForElementToClick(String accessType, String accessName, String duration) {
		By byEle = getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(po.getDriver(), Integer.parseInt(duration) * 1000));
		wait.until(ExpectedConditions.elementToBeClickable(byEle));
	}
}
