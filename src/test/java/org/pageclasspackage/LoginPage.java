package org.pageclasspackage;

import java.time.Duration;
import java.util.Arrays;

import org.basepackage.VisionBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class LoginPage extends VisionBase {

	  AppiumDriver driver;

	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement liveClassroomNext;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement performAnalysNext;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement allIndiaPrlimsNext;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]") 
	private WebElement allIndiaMainsNext;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
	private WebElement freeResourcesContinue;

	@AndroidFindBy(xpath = "(//android.widget.ImageView)[11]")
	private WebElement menuAtBottom;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
	private WebElement login;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement username;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement password;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Welcome Back!\"]")
	private WebElement welcome;
	
	public void clickOnNextLiveClassroom11() {
	    if (liveClassroomNext != null) {
	        System.out.println("Next class button is initialized.");
	        waitForElementClickability(liveClassroomNext,driver);
	        liveClassroomNext.click();
	    } else {
	        System.out.println("Next class button is NOT initialized.");
	        throw new RuntimeException("Next class button is not initialized.");
	    }
	}


	public LoginPage clickOnNextLiveClassroom() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(liveClassroomNext,driver);
		liveClassroomNext.click();
		return this;
	}

	public LoginPage clickOnNextLivePerformAnalyst() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(performAnalysNext,driver);
		performAnalysNext.click();
		return this;
	}

	public LoginPage clickOnNextAllIndiaPrlims() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(allIndiaPrlimsNext,driver);
		allIndiaPrlimsNext.click();
		return this;
	}

	public LoginPage clickOnNextAllIndiaMains() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(allIndiaMainsNext,driver);
		allIndiaMainsNext.click();
		return this;
	}

	public LoginPage clickOnContinueFreeResources() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(freeResourcesContinue,driver);
		freeResourcesContinue.click();
		return this;
	}

	public boolean isWelcomeDisplayedOnLoginScreen() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForSingleElementVisibility(welcome,driver);
		welcome.click();
		return welcome.isDisplayed();
	}

	public LoginPage clickOnMenu() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(menuAtBottom,driver);
		menuAtBottom.click();
		String base = captureScreenShotBase64(driver);
		extentTest.addScreenCaptureFromBase64String(base, "Screenshot of login page");
		return this;
	}

	// Entering Email Address in the Login page
	public LoginPage enterUsername(String email) {
		waitForSingleElementVisibility(username,driver);
		username.sendKeys(email);
		String val = username.getAttribute("value");
		extentTest.info("Entered Email  : " + val);
		return this;
	}

	public LoginPage clickOnPasswordField() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(password,driver);
		password.click();
		return this;
	}

	// Entering password in the Login page
	public LoginPage enterPassword(String pwd) {
		waitForSingleElementVisibility(password,driver);
		password.sendKeys(pwd);
		String val = password.getAttribute("value");
		extentTest.info("Entered password  : " + val);
		return this;
	}

	public LoginPage touchOnTheScreen() throws InterruptedException {

		// Define the point where you want to touch the screen (modify x and y as
		// needed)
		Point tapPoint = new Point(400, 600);

		// Create an input source for touch actions
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		// Create a loop to tap the screen 5 times
		for (int i = 0; i < 6; i++) {
			// Create a sequence to represent the tap action
			Sequence tapSequence = new Sequence(finger, 1);

			// Move to the tap point
			tapSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
					tapPoint.x, tapPoint.y));

			// Tap down
			tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

			// Tap up (to complete the tap action)
			tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			// Perform the tap action
			((RemoteWebDriver) driver).perform(Arrays.asList(tapSequence));

			// Optionally add a small delay between taps
			Thread.sleep(2000); // Adjust the sleep time as needed
		}

		return this;

	}

	public LoginPage clickOnLoginButton() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(login,driver);
		login.click();
		String base = captureScreenShotBase64(driver);
		extentTest.addScreenCaptureFromBase64String(base, "Screenshot of login page");
		return this;
	}

}
