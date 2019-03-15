package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkBase.PageObjectBase;

public class Authentication extends PageObjectBase {
	
	public Authentication() {
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
	private WebElement btn_SignIn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement txt_User;
	
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
	private WebElement txt_Password;
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']//li")
	private WebElement lbl_ErrorMessage;
	//

	/**
	 * Input the username and password and clicks in Sigin button
	 * @param user
	 * @param password
	 */
	public void logIn(String user, String password) {
		try {
			txt_User.sendKeys(user);
			txt_Password.sendKeys(password);
			btn_SignIn.click();
			reporter.methodPassed();
		} catch (Exception | AssertionError e) {
			reporter.caseFailed("Couldn't identify My sotre landing page - " + e.getMessage());
		}
	}
	
	
	/**
	 * Validate the error message that appears in the log in page
	 * @param errorMessage
	 */
	public void validateLogInErrorMessage(String errorMessage) {
		try {
			assertTrue("Error message was not found", errorMessage.equals(lbl_ErrorMessage.getText()));
			reporter.methodPassed();
		} catch (Exception | AssertionError e) {
			reporter.caseFailed("Error message was not present - " + e.getMessage());
		}
	}
	
	

}
