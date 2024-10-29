package org.utilitypackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig {
	
	Properties prop;

	public ReadConfig() {

		File file = new File("./configuration/config.properties");
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(file);
			prop.load(fs);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	
	public String getDeviceName() {
	    return prop.getProperty("deviceName");
	}
	
	public String getAppUdid() {
	    return prop.getProperty("udid");
	}


	public String getAppPath() {
	    return prop.getProperty("appPath");
	}

	public String getAppPackage() {
	    return prop.getProperty("appPackage");
	}

	public String getAppActivity() {
	    return prop.getProperty("appActivity");
	}

	public String getAppUsername() {
	    return prop.getProperty("username");
	}

	public String getAppPassword() {
	    return prop.getProperty("password");
	}
	public String getAppURL() {
	    return prop.getProperty("url");
	}

}
