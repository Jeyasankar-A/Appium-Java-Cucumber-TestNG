package org.pageobjectmanager;

import org.basepackage.VisionAppLaunch;
import org.openqa.selenium.WebDriver;
import org.pageclasspackage.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {

	private LoginPage loginPage;
	private VisionAppLaunch visionAppLaunch;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public VisionAppLaunch getVisionAppLaunch(WebDriver driver) {
		return (visionAppLaunch == null) ? visionAppLaunch = new VisionAppLaunch() : visionAppLaunch;
	}
}
