package stepDefinitions;

import org.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.basepackage.VisionBase;

import java.net.MalformedURLException;

public class Login extends VisionBase {

	PageObjectManager pom = new PageObjectManager();

	@Given("I launch the app")
	public void iLaunchTheApp() throws MalformedURLException, InterruptedException {

		pom.getVisionAppLaunch(driver).setupAppLaunch();
		Thread.sleep(10000);

		// Click on the "Live Classroom" Next button
		pom.getLoginPage().clickOnNextLiveClassroom();
		Thread.sleep(2000);

		// Click on the "Performance Analysis" Next button
		pom.getLoginPage().clickOnNextLivePerformAnalyst();
		Thread.sleep(2000);

		// Click on the "All India Prelims" Next button
		pom.getLoginPage().clickOnNextAllIndiaPrlims();
		Thread.sleep(2000);

		// Click on the "All India Mains" Next button
		pom.getLoginPage().clickOnNextAllIndiaMains();
		Thread.sleep(2000);

		// Click on the "Free Resources" Continue button us
		pom.getLoginPage().clickOnContinueFreeResources();
		Thread.sleep(2000);

		pom.getLoginPage().touchOnTheScreen();
		Thread.sleep(2000);

	}

	@When("I click on the login button")
	public void iClickOnTheLoginButton() throws InterruptedException {

		// Click on the "Menu" at bottom
		pom.getLoginPage().clickOnMenu();

		pom.getLoginPage().clickOnLoginButton();

		Thread.sleep(4000);

	}

	@Then("I should see the login page")
	public void iShouldSeeTheLoginPage() throws InterruptedException {

		// Click on the "Menu" at bottom
		pom.getLoginPage().enterUsername(email);
		Thread.sleep(2000);

		pom.getLoginPage().clickOnPasswordField();
		Thread.sleep(2000);

		pom.getLoginPage().enterPassword(password);
		Thread.sleep(2000);

		pom.getLoginPage().isWelcomeDisplayedOnLoginScreen();
		Thread.sleep(2000);

		pom.getLoginPage().clickOnLoginButton();
		Thread.sleep(2000);

	}

}
