package org.pageobjectmanager;

import org.basepackage.VisionAppLaunch;
import org.pageclasspackage.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {

	private LoginPage loginPage;
	private VisionAppLaunch visionAppLaunch;

	public LoginPage getLoginPage(AppiumDriver driver) {
		return (loginPage == null) ? loginPage = new LoginPage((AndroidDriver) driver) : loginPage;
	}

	public VisionAppLaunch getVisionAppLaunch(AppiumDriver driver) {
		return (visionAppLaunch == null) ? visionAppLaunch = new VisionAppLaunch() : visionAppLaunch;
	}
}
