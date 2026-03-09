package base;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;



public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport()
	{
		extent = ExtentReportManager.getReportInstance();
	}
	@AfterSuite
	public void teardownReport()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setUp() {
		Log.info("Starting Chrome Browser.......");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");//chrome version
		co.addArguments("--disable-blink-features=AutomationControlled");//chaptcha google image 
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		Log.info("Navigating to URL.....");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed..Check Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		if(driver != null) {
			Log.info("Closing Browser ...");
			driver.quit();
		}
	}
	
}
