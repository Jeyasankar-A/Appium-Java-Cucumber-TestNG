package org.basepackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.utilitypackage.ReadConfig;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VisionAppLaunch {
	
	protected AndroidDriver driver;
	
	ReadConfig readconfig = new ReadConfig();


	public String devicename = readconfig.getDeviceName();
	public String path = readconfig.getAppPath();
	public String packagename = readconfig.getAppPackage();
	public String activity = readconfig.getAppActivity();
	public String udid = readconfig.getAppUdid();
	public String url = readconfig.getAppURL();
	public String email = readconfig.getAppUsername();
	public String password = readconfig.getAppPassword();
	
	public void setupAppLaunch() {
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
	            driver = (new AndroidDriver (new URL(url), capabilities));
	            System.out.println("Application launched successfully!");
	        } 
	        catch (MalformedURLException e) {
	            e.printStackTrace();
	            System.err.println("Failed to create AndroidDriver. Check the URL and capabilities.");
	        }
	}
}
