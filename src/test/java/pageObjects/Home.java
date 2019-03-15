package pageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import frameworkBase.PageObjectBase;

public class Home extends PageObjectBase {
	String Url = getEnvironment();
	
	public Home(boolean navigateToPage) {
		PageFactory.initElements(driver, this);
		if (navigateToPage) {
			driver.get(Url);
		}
	}
	
	//Locators
	@FindBy(how = How.XPATH, using = "//img[@alt='My Store' and @class='logo img-responsive']")
	private WebElement lnk_MyStore;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sign in') and @class='login']")
	private WebElement btn_SignIn;
	
	private static By by_lbl_Title(String tittle) {
		return By.xpath("//h1[@class='page-heading' and text()='" + tittle + "']");
	}
	//

	/**
	 * Verify that we land in the proper My Store landing page
	 */
	public void verifyLanding() {
		try {
			assertTrue("My store logo didn't load", lnk_MyStore.isDisplayed());
			reporter.methodPassed();
		} catch (Exception | AssertionError e) {
			reporter.caseFailed("Couldn't identify My sotre landing page - " + e.getMessage());
		}
	}
	
	/**
	 * Clicks in login button an verify the tittle
	 */
	public void goToLogin() {
		try {
			btn_SignIn.click();
			assertTrue("Authentication page didn't load", verifyTitle("Authentication"));
			reporter.methodPassed();
		} catch (Exception | AssertionError e) {
			reporter.caseFailed("Couldn't identify My sotre landing page - " + e.getMessage());
		}
	}
	
	/**
	 * Verify that the desired title is present
	 * @param tittle
	 * @return true or false, depending on the outcome
	 */
	public static boolean verifyTitle(String title) {
		try {
			return driver.findElement(by_lbl_Title(title)).isDisplayed();
		} catch (Exception e) {
			System.out.println("There was an error in the title verification. - " + e.getMessage());
			return false;
		}
	}
	
}
