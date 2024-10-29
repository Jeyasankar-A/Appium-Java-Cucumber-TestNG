package org.visionbase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VisionAppBaseClass {

	public static WebDriver driver;
	static URL url;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Create an object of DesiredCapabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// General desired capabilities
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0");
		capabilities.setCapability(MobileCapabilityType.APP, "com.vision.visionias.app");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto g24");
		capabilities.setCapability(MobileCapabilityType.UDID, "ZD222LFXGS");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		// Automatically grant app permissions
		capabilities.setCapability("autoGrantPermissions", true);

		// For .apk file of the application
		capabilities.setCapability(MobileCapabilityType.APP,
				"E:\\Eclipse\\FlutterVisionApp\\src\\test\\resources\\apps\\app-release.apk");

		// Start the Android driver with the Appium server
		URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

		// Verify that the app launched
		System.out.println("Application launched successfully!");

		Thread.sleep(2000);

		// Click the "View Full Screen" OK button to proceed
		// WebElement viewFullScreenGotIt = driver.findElement(By.id("android:id/ok"));

		// viewFullScreenGotIt.click();

		// Click on the "Live Classroom" Next button using XPath
		WebElement liveClassroomNext = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));

		liveClassroomNext.click();

		// Click on the "Performance Analysis" Next button using XPath
		WebElement performAnalysNext = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));

		performAnalysNext.click();

		// Click on the "All India Prelims" Next button using XPath
		WebElement allIndiaPrlimsNext = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));

		allIndiaPrlimsNext.click();

		// Click on the "All India Mains" Next button using XPath
		WebElement allIndiaMainsNext = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));

		allIndiaMainsNext.click();

		// Click on the "Free Resources" Continue button using XPath
		WebElement freeResourcesContinue = driver
				.findElement(By.xpath("//android.widget.Button[@content-desc='Continue']"));

		freeResourcesContinue.click();

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
			driver.perform(Arrays.asList(tapSequence));

			// Optionally add a small delay between taps
			Thread.sleep(2000); // Adjust the sleep time as needed
		}

		// Click on the "Menu" at bottom using XPath
		WebElement menuAtBottom = driver.findElement(By.xpath("(//android.widget.ImageView)[11]"));
		menuAtBottom.click();

		WebElement login = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
		login.click();

		Thread.sleep(4000);

		WebElement username = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
		username.sendKeys("jeyasankar@visionias.in");
		
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
		password.click();
		Thread.sleep(2000);
		
		password.sendKeys("123456");
		Thread.sleep(2000);
		
		WebElement welcome = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome Back!\"]"));
		welcome.click();
		Thread.sleep(2000);
		
		WebElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
		loginButton.click();

		Thread.sleep(5000);
		driver.quit();

	}
}
