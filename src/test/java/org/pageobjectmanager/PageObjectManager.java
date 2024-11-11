package org.pageobjectmanager;

import org.basepackage.VisionAppLaunch;
import org.openqa.selenium.WebDriver;
import org.pageclasspackage.LoginPage;

public class PageObjectManager {

    private LoginPage loginPage;
    private VisionAppLaunch visionAppLaunch;


    public LoginPage getLoginPage(WebDriver driver) {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

    public VisionAppLaunch getVisionAppLaunch(WebDriver driver) {
		return (visionAppLaunch == null) ? visionAppLaunch = new VisionAppLaunch() : visionAppLaunch;
	}
    
}

