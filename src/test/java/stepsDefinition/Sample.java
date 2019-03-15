package stepsDefinition;

import cucumber.api.java8.En;
import frameworkBase.PageObjectBase;
import pageObjects.Authentication;
import pageObjects.Home;

public class Sample implements En {
	Home home;
	Authentication authentication;
	
	public Sample() {
		Given("I'm in My store main page", () -> {
			home = new Home(true);
			home.verifyLanding();
		});

		Given("I navigate to the log in page", () -> {
			home.goToLogin();
		});
		
		When("I try to login with an unexisting user", () -> {
			authentication = new Authentication();
			authentication.logIn(PageObjectBase.testScenario.testData.get("User"), PageObjectBase.testScenario.testData.get("Password"));
		});

		When("An authentication failed error message appear", () -> {
			authentication.validateLogInErrorMessage(PageObjectBase.testScenario.testData.get("Error Message"));
		});
	}
}