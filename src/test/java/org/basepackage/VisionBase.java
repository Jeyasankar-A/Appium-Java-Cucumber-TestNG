package org.basepackage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.utilitypackage.ReadConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class VisionBase {

	public static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();

	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	public String devicename = readconfig.getDeviceName();
	public String path = readconfig.getAppPath();
	public String packagename = readconfig.getAppPackage();
	public String activity = readconfig.getAppActivity();
	public String udid = readconfig.getAppUdid();
	public String url = readconfig.getAppURL();
	public String email = readconfig.getAppUsername();
	public String password = readconfig.getAppPassword();
 

//	@BeforeSuite(alwaysRun = true)
	public void initiateExtentReports() {
		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		extentReports.attachReporter(sparkReporter_all);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Testing Framework", "Cucumber");
	}

//	@AfterSuite(alwaysRun = true)
	public void generateExtentReport() {
		extentReports.flush();
	}

	//@BeforeMethod
	public void setupTest(Method method) {
		extentTest = extentReports.createTest(method.getName());
	}

	// To attach Screenshot to Extent Report
//	@AfterMethod(alwaysRun = true)
	public void checkStatus(Method m, ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = null;

			screenshotPath = captureScreenshot(
					result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg",
					driver);

			extentTest.addScreenCaptureFromPath(screenshotPath);

			extentTest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.pass(m.getName() + " is passed");
		}

//		extentTest.assignCategory(m.getAnnotation(Test.class).groups());

//		extentTest.assignCategory(m.getAnnotation(Test.class).testName());

	}

	// to capture the screenshot
	public static String captureScreenshot(String fileName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./reports/" + fileName);

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getAbsolutePath();

	}

	public static String captureScreenShotBase64(WebDriver driver2) {
		TakesScreenshot ts = (TakesScreenshot) driver2;
		return ts.getScreenshotAs(OutputType.BASE64);
	}


	protected void waitForElementClickability(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitForSingleElementVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
