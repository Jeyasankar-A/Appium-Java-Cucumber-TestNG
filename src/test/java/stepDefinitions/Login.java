package stepDefinitions;

import org.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.basepackage.VisionBase;

import java.net.MalformedURLException;

public class Login extends VisionBase {

	@Given("I launch the app")
	public void iLaunchTheApp() throws MalformedURLException, InterruptedException {

		PageObjectManager pom = new PageObjectManager();
		pom.getVisionAppLaunch(getDriver()).setupAppLaunch();
		Thread.sleep(10000);

		// Click on the "Live Classroom" Next button
		pom.getLoginPage(getDriver()).clickOnNextLiveClassroom();
		Thread.sleep(2000);

		// Click on the "Performance Analysis" Next button
		pom.getLoginPage(getDriver()).clickOnNextLivePerformAnalyst();
		Thread.sleep(2000);

		// Click on the "All India Prelims" Next button
		pom.getLoginPage(getDriver()).clickOnNextAllIndiaPrlims();
		Thread.sleep(2000);

		// Click on the "All India Mains" Next button
		pom.getLoginPage(getDriver()).clickOnNextAllIndiaMains();
		Thread.sleep(2000);

		// Click on the "Free Resources" Continue button us
		pom.getLoginPage(getDriver()).clickOnContinueFreeResources();
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).touchOnTheScreen();

	}

	@When("I click on the login button")
	public void iClickOnTheLoginButton() throws InterruptedException {

		PageObjectManager pom = new PageObjectManager();

		// Click on the "Menu" at bottom
		pom.getLoginPage(getDriver()).clickOnMenu(); 

		pom.getLoginPage(getDriver()).clickOnLoginButton();

		Thread.sleep(4000);

	}

	@Then("I should see the login page")
	public void iShouldSeeTheLoginPage() throws InterruptedException {

		PageObjectManager pom = new PageObjectManager();

		// Click on the "Menu" at bottom
		pom.getLoginPage(getDriver()).enterUsername(email);
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).clickOnPasswordField();
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).enterPassword(password);
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).isWelcomeDisplayedOnLoginScreen();
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).clickOnLoginButton();
		Thread.sleep(2000);

	}
}
