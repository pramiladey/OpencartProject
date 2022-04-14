package com.opencart.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ModuleTest {
	static WebDriver driver;
	public static String browserName = "Chrome";
	static ExtentTest test;
	static ExtentReports report;
	private CommonModuleTest commonpage;

	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\final_ExtentReportResults.html");
		test = report.startTest("Opencart_Project");
	}

	@Test(priority=1)
	public void driverSetup() {

		if (browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.contains("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32(1)//chromedriver.exe");
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		test.log(LogStatus.PASS,"Browser opend sucessfully");

		driver.get("http://localhost/opencartap/");
		test.log(LogStatus.PASS,"URL of application is working");
		commonpage = new CommonModuleTest(driver);}


	@Test(priority=2)
	public void LoginWithInvalidCred() throws IOException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		commonpage.validateUpdatefunc(driver,1);
		test.log(LogStatus.PASS,"login with invalid credentials");
	}
	@Test(priority=3)
	public void LoginWithBlankField() throws IOException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		commonpage.validateUpdatefunc(driver,3);
		test.log(LogStatus.PASS,"login with blank fields credentials");
	}
	@Test(priority=4)
	public void LoginWithValidCred() throws IOException {
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		commonpage.validateUpdatefunc(driver,2);
		test.log(LogStatus.PASS,"login with valid credentials");

	}
	@Test(priority=5)
	public void MyOrderview() {

		commonpage.MyOrdersview(driver);
		test.log(LogStatus.PASS,"myorder viewd");

	}
	@Test(priority=6)
	public void MyOrderviewDownloads() {

		commonpage.MyOrdersviewDownloads(driver);
		test.log(LogStatus.PASS,"myOrder view downloads");

	}
	@Test(priority=7)
	public void MyorderrewardPoints() {

		commonpage.MyordersrewardPoints(driver);
		test.log(LogStatus.PASS,"myorders reward points");

	}
	@Test(priority=8)
	public void MyorderreturnRequest() {

		commonpage.MyordersreturnRequest(driver);
		test.log(LogStatus.PASS,"myorders return request");}


	@Test(priority=9)
	public void searchFunction(){

		commonpage.SearchFunction(driver);
		test.log(LogStatus.PASS,"Search functionality tested");


	}
	@Test(priority=10)
	public void RemoveFromWishlist() {

		commonpage.removeFromWishlist(driver);
		test.log(LogStatus.PASS,"Removed sucessfully");

	}
	@Test(priority=11)
	public void LogoutFunction() {

		commonpage.LogoutFnctionTest(driver);
		test.log(LogStatus.PASS,"logged out Sucessfully");

	}

	@Test(priority=12)
	public void closeBrowser() {
		driver.close();
		test.log(LogStatus.PASS,"Browser closed Sucessfully");
	}
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}





}
