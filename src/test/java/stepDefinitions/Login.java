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
		pom.getLoginPage(driver).clickOnNextLiveClassroom();
		Thread.sleep(2000);

		// Click on the "Performance Analysis" Next button
		pom.getLoginPage(driver).clickOnNextLivePerformAnalyst();
		Thread.sleep(2000);

		// Click on the "All India Prelims" Next button
		pom.getLoginPage(driver).clickOnNextAllIndiaPrlims();
		Thread.sleep(2000);

		// Click on the "All India Mains" Next button
		pom.getLoginPage(driver).clickOnNextAllIndiaMains();
		Thread.sleep(2000);

		// Click on the "Free Resources" Continue button us
		pom.getLoginPage(driver).clickOnContinueFreeResources();
		Thread.sleep(2000);

		pom.getLoginPage(driver).touchOnTheScreen();
		Thread.sleep(2000);

	}

	@When("I click on the login button")
	public void iClickOnTheLoginButton() throws InterruptedException {

		// Click on the "Menu" at bottom
		pom.getLoginPage(driver).clickOnMenu();

		pom.getLoginPage(driver).clickOnLoginButton();

		Thread.sleep(4000);

	}

	@Then("I should see the login page")
	public void iShouldSeeTheLoginPage() throws InterruptedException {

		// Click on the "Menu" at bottom
		pom.getLoginPage(driver).enterUsername(email);
		Thread.sleep(2000);

		pom.getLoginPage(driver).clickOnPasswordField();
		Thread.sleep(2000);

		pom.getLoginPage(driver).enterPassword(password);
		Thread.sleep(2000);

		pom.getLoginPage(driver).isWelcomeDisplayedOnLoginScreen();
		Thread.sleep(2000);

		pom.getLoginPage(driver).clickOnLoginButton();
		Thread.sleep(2000);

	}
}
