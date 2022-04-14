package com.opencart.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.opencart.common.CommonPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class FinalTest {
	static WebDriver driver;
	public static String browserName = "chrome";
	static String email,password;
	static ExtentTest test;
	static ExtentReports report;



	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\final_ExtentReportResults.html");
		test = report.startTest("Opencart_Modules");
	}

	@Test(priority=1)
	public void driverSetup() {
//
//		if (browserName.contains("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if (browserName.contains("EDGE")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}

		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32 (1)//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		//test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}

	//Login
	@Test(priority=2) 
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
	@Test(priority=3)
	public void LoginwithBlankField() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String email="";
		String password="";

		WebElement click=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		click.click();
		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		CommonPage.moveToElement(element,driver);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		String type=email,type1=password;
		if(type.contains(email) && type1.contains(password)) {
			test.log(LogStatus.PASS,"Test Passed Sucessfully");}
	}
	@Test (priority=4)

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
	//MyOrders

	@Test(priority =5)
	public void MyOrdersview() {
		driver.navigate().back();
		//Thread.sleep(2000);
		driver.navigate().back();
		//Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}
	@Test(priority =6)
	public void MyOrdersviewDownloads() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}
	@Test(priority =7)
	public void MyordersrewardPoints() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}
	@Test(priority =8)
	public void MyordersreturnRequest() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}

	//search

	@Test(priority=9)
	public void SearchButtonClickable() {
		driver.findElement(By.name("search")).clear();
		WebElement laptop=driver.findElement(By.name("search"));
		laptop.sendKeys("laptop");

		if(laptop.isDisplayed()) {
			test.log(LogStatus.PASS,"Test Passed Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Test has failed");

		}
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		//Thread.sleep(2000);
	}
	@Test(priority=10)
	public void SearchCategoryIdSelected() {

		driver.findElement(By.name("description")).click();
		//Thread.sleep(2000);

		Select select = new Select(driver.findElement(By.name("category_id")));
		select.selectByIndex(2);

		if((driver.findElement(By.name("category_id")).isSelected()));
		test.log(LogStatus.PASS,"Test Passed Sucessfully");
	}

	@Test(priority=11)
	public void SearchSubCategoryEnable(){

		WebElement sub=driver.findElement(By.name("sub_category"));
		sub.click();

		if(sub.isEnabled()) {
			test.log(LogStatus.PASS,"Test Passed Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Test has failed");

		}

		driver.findElement(By.id("button-search")).click();
		Navigation manage=driver.navigate();
		manage.back();

	}
	//Desktop
	@Test(priority=12)
	public void DesktopopenModule() throws InterruptedException {
		WebElement desktop=driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
		desktop.click();
		if(desktop.isEnabled()) {
			test.log(LogStatus.PASS,"Test Passed Sucessfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"Test has failed");

		}
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
		//Thread.sleep(2000);

	}
	@Test(priority=13)
	public void DesktopsortProductByPrice() throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("input-sort")));
		select.selectByIndex(3);
		Thread.sleep(2000);

	}
	@Test(priority=14)
	public void DesktopShowingByList() throws InterruptedException {
		driver.findElement(By.id("list-view")).click();
		//Thread.sleep(2000);

	}

	@Test(priority=15)
	public void DesktopselectProduct() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		//Thread.sleep(2000);

	}
	@Test(priority=16)
	public void DesktopaddToWishlist() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		//		Alert alert=driver.switchTo().alert();
		//		Thread.sleep(2000);
		//		alert.accept();
		//		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

		//Thread.sleep(5000);

	}

	@Test(priority=17)
	public void DesktopaddToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.id("input-option226")));
		select.selectByIndex(1);

		driver.findElement(By.id("button-cart")).click();
		//		Alert alert=driver.switchTo().alert();
		//		Thread.sleep(2000);
		//		alert.accept();
		//		Thread.sleep(2000);

		driver.navigate().back();

	}

	//Wish-list

	@Test(priority=18)
	public void removeFromWishlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();


	}

	//mp3 product
	@Test(priority=19)
	public void Mp3FunctionButtonTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Show All MP3 Players')]")).click();

		//Sorting 
		Select s = new Select(driver.findElement(By.id("input-sort")));
		s.selectByIndex(2);
		//Show in List
		driver.findElement(By.id("list-view")).click();
		//Select iPod Touch
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		//Added to wish list 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		//		Alert alert=driver.switchTo().alert();
		//		Thread.sleep(2000);
		//		alert.accept();

		//Add to cart
		driver.findElement(By.id("button-cart")).click();
		//Thread.sleep(2000);
	}
	//Logout

	@Test(priority=20)
	public void LogoutFunctionTest() {

		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));
		CommonPage.moveToElement(element,driver);
		//		Actions a=new Actions(driver);
		//        a.moveToElement(elemnt1).click().perform();
		WebElement log=driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[3]/a"));
		if(log.isDisplayed()) {
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

	@AfterTest
	public void closeBrowser() {
		driver.close();
		test.log(LogStatus.PASS,"Test Passed Sucessfully");


	}
}