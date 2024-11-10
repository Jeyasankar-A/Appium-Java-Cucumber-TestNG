package stepDefinitions;

import org.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.basepackage.VisionBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

public class Login extends VisionBase {

	PageObjectManager pom = new PageObjectManager();

	@Given("I launch the app")
	public void iLaunchTheApp() throws MalformedURLException, InterruptedException {

		pom.getVisionAppLaunch(getDriver()).setupAppLaunch();
		Thread.sleep(5000);

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
		Thread.sleep(4000);

	}

	@When("I click on the login button")
	public void iClickOnTheLoginButton() throws InterruptedException {
		
		pom.getLoginPage(getDriver()).clickOnMenu();
		
		pom.getLoginPage(getDriver()).clickOnLoginButton();
		Thread.sleep(4000); // Ensure the next screen loads

	}

	@Then("I should see the login page")
	public void iShouldSeeTheLoginPage() throws InterruptedException {
		pom.getLoginPage(getDriver()).enterUsername(email);
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).clickOnPasswordField();
		Thread.sleep(2000);

		pom.getLoginPage(getDriver()).enterPassword(password);
		Thread.sleep(2000);

		// Check if welcome message is displayed
		assertTrue(pom.getLoginPage(getDriver()).isWelcomeDisplayedOnLoginScreen());

		pom.getLoginPage(getDriver()).clickOnLoginButton();
		Thread.sleep(2000);
	}

}
