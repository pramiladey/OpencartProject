package com.opencart.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.opencart.common.CommonPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest {
	WebDriver driver;
	static String email,password;
	//CommonPage page;
	CommonModuleTest loginpage;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\final_ExtentReportResults.html");
		test = report.startTest("Opencart_Modules");
	}


	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartap/");
	}


	@Test(priority=1) 
	public void LoginInvalidCredentials() throws InterruptedException, IOException {
		File src =new File("OpenCart_ReadData.xlsx");
		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);
		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		email=sheet1.getRow(1).getCell(1).getStringCellValue();
		password=sheet1.getRow(1).getCell(2).getStringCellValue();

		driver.get("http://localhost/opencartap/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement click=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		click.click();

		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		CommonPage.moveToElement(element,driver);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		//loginpage =new LoginPageFactory(driver);
		Thread.sleep(2000);

		String type = email;
		String type1=password;
		if(type.contains(email) && type1.contains(password)) {

			test.log(LogStatus.PASS, "Trying to open with invalid credentials and test should be passed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test case failed");
		}


		driver.navigate().back();

	}
	@Test(priority=2)
	public void LoginwithBlankField() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String email="";
		String password="";
//
		WebElement click=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		click.click();
		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		CommonPage.moveToElement(element,driver);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		//loginpage.validateUpdatefunc(driver);

		String type=email,type1=password;
		if(type.contains(email) && type1.contains(password)) {
			test.log(LogStatus.PASS,"Test Passed Sucessfully");}
	}
	@Test (priority=3)

	public  void LoginValidCredentials() throws InterruptedException, IOException {
		File src =new File("OpenCart_ReadData.xlsx");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);

		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		email=sheet1.getRow(2).getCell(1).getStringCellValue();
		password=sheet1.getRow(2).getCell(2).getStringCellValue();

		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		CommonPage.moveToElement(element,driver);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		//Thread.sleep(2000);

		String type = email;
		String type1=password;
		if(type.contains(email) && type1.contains(password)) {
			driver.findElement(By.id("content"));
			test.log(LogStatus.PASS,"Test Passed Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Test has failed");

		}

	}
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}


	@Test(groups= {"Regression"},priority=4)
	public void closeBrowser() {
		driver.close();
		

	}


}



