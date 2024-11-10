package org.pageclasspackage;

import java.time.Duration;
import java.util.Arrays;

import org.basepackage.VisionBase;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends VisionBase {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement liveClassroomNext;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement performAnalysNext;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement allIndiaPrlimsNext;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Next\"]")
	private WebElement allIndiaMainsNext;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
	private WebElement freeResourcesContinue;

	@FindBy(xpath = "(//android.widget.ImageView)[11]")
	private WebElement menuAtBottom;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
	private WebElement login;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement username;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement password;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Welcome Back!\"]")
	private WebElement welcome;


	public LoginPage clickOnNextLiveClassroom() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(liveClassroomNext,driver);
		liveClassroomNext.click();
		return this;
	}

	public LoginPage clickOnNextLivePerformAnalyst() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(performAnalysNext, driver);
		performAnalysNext.click();
		return this;
	}

	public LoginPage clickOnNextAllIndiaPrlims() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(allIndiaPrlimsNext, driver);
		allIndiaPrlimsNext.click();
		return this;
	}

	public LoginPage clickOnNextAllIndiaMains() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(allIndiaMainsNext, driver);
		allIndiaMainsNext.click();
		return this;
	}

	public LoginPage clickOnContinueFreeResources() {
		// Wait for a maximum of 30 seconds
		waitForElementClickability(freeResourcesContinue, driver);
		freeResourcesContinue.click();
		return this;
	}

	public boolean isWelcomeDisplayedOnLoginScreen() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForSingleElementVisibility(welcome, driver);
		welcome.click();
		return welcome.isDisplayed();
	}

	public LoginPage clickOnMenu() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(menuAtBottom, driver);
		menuAtBottom.click();
//		String base = captureScreenShotBase64(driver);
//		extentTest.addScreenCaptureFromBase64String(base, "Screenshot of login page");
		return this;
	}

	// Entering Email Address in the Login page
	public LoginPage enterUsername(String email) {
		waitForSingleElementVisibility(username, driver);
		username.sendKeys(email);
		return this;
	}

	public LoginPage clickOnPasswordField() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(password, driver);
		password.click();
		return this;
	}

	// Entering password in the Login page
	public LoginPage enterPassword(String pwd) {
		waitForSingleElementVisibility(password, driver);
		password.sendKeys(pwd);
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
			Thread.sleep(1000); // Adjust the sleep time as needed
		}

		return this;

	}

	public LoginPage clickOnLoginButton() {
		// Wait for a maximum of 30 seconds for the banner text to be displayed
		waitForElementClickability(login, driver);
		login.click();
//		String base = captureScreenShotBase64(driver);
//		extentTest.addScreenCaptureFromBase64String(base, "Screenshot of login page");
		return this;
	}

}
