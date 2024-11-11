package org.basepackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.pageobjectmanager.PageObjectManager;
import org.utilitypackage.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class VisionAppLaunch extends VisionBase {

	public WebDriver driver;

	ReadConfig readconfig = new ReadConfig();
	public String devicename = readconfig.getDeviceName();
	public String path = readconfig.getAppPath();
	public String packagename = readconfig.getAppPackage();
	public String activity = readconfig.getAppActivity();
	public String udid = readconfig.getAppUdid();
	public String url = readconfig.getAppURL();
	public String email = readconfig.getAppUsername();
	public String password = readconfig.getAppPassword();

	PageObjectManager pom = new PageObjectManager();

//	@Before
	public void setupAppLaunch() throws InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability(MobileCapabilityType.APP, path);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activity);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability("autoGrantPermissions", true);

		try {
			driver = new AndroidDriver(new URL(url), capabilities);
		//	setDriver(driver); // Add this line to set the driver in ThreadLocal
			System.out.println("Application launched successfully!");
			Thread.sleep(8000);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("Failed to create AndroidDriver. Check the URL and capabilities.");
		}

		/*
		 * // Click on the "Live Classroom" Next button
		 * pom.getLoginPage(driver).clickOnNextLiveClassroom(); Thread.sleep(2000);
		 * 
		 * // Click on the "Performance Analysis" Next button
		 * pom.getLoginPage(driver).clickOnNextLivePerformAnalyst(); Thread.sleep(2000);
		 * 
		 * // Click on the "All India Prelims" Next button
		 * pom.getLoginPage(driver).clickOnNextAllIndiaPrlims(); Thread.sleep(2000);
		 * 
		 * // Click on the "All India Mains" Next button
		 * pom.getLoginPage(driver).clickOnNextAllIndiaMains(); Thread.sleep(2000);
		 * 
		 * // Click on the "Free Resources" Continue button us
		 * pom.getLoginPage(driver).clickOnContinueFreeResources(); Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).touchOnTheScreen(); Thread.sleep(4000);
		 * 
		 * // Click on the "Menu" at bottom pom.getLoginPage(driver).clickOnMenu();
		 * Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).clickOnLoginButton();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).enterUsername(email); Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).clickOnPasswordField(); Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).enterPassword(password); Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).isWelcomeDisplayedOnLoginScreen();
		 * Thread.sleep(2000);
		 * 
		 * pom.getLoginPage(driver).clickOnLoginButton(); Thread.sleep(2000);
		 * 
		 */
	}

//	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
