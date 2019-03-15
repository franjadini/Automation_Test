package stepsDefinition;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import frameworkBase.PageObjectBase;

public class Hooks implements En {

	//Don't modify this unless you are entirely sure

	public Hooks() {

		Before(0, (Scenario scenario) -> {
			PageObjectBase.initiateNewCase(scenario);
		});

		BeforeStep(() -> {
			PageObjectBase.reporter.stepStarted();
		});

		Given("I sucessfully load the case data \"([^\"]*)\"", (String testCaseID) -> {
			PageObjectBase.loadTestData(testCaseID);
		});

		AfterStep(() -> {
			PageObjectBase.reporter.stepPassed();
			PageObjectBase.testScenario.currentStep++;
		});

		// Log out
		After(1, (Scenario scenario) -> {
			
		});

		// Send report and close browser
		After(0, (Scenario scenario) -> {
			PageObjectBase.reporter.scenarioFinished();
			PageObjectBase.endBrowserSession();
		});
	}
}