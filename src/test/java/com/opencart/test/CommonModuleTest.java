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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.opencart.common.CommonPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonModuleTest {
	//login
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;
	@FindBy(how=How.XPATH,using="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement login;
	@FindBy(id="input-email")
	WebElement useremail;
	@FindBy(id="input-password")
	WebElement pass;
	@FindBy(how=How.XPATH,using="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement submit;

	//search
	@FindBy(name="search") WebElement searchbutton;
	@FindBy(xpath="//*[@id=\"search\"]/span/button") WebElement SearchClick;
	@FindBy(name="description") WebElement description;
	@FindBy(name="category_id") WebElement categoryId;
	@FindBy(name="sub_category") WebElement subcategory;
	@FindBy(id="button-search") WebElement buttonsearch;

	//my-orders
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[1]/a") WebElement myorderbutton;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")WebElement myorderviewclick;

	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[2]/a")WebElement myorderdownload;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")WebElement myorderdownloadview;

	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[3]/a")WebElement myorderreward;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/a")WebElement myorderrewardview;

	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[4]/a")WebElement ordersreturnbutton;
	//wishlist
	@FindBy(xpath="//*[@id=\"wishlist-total\"]") WebElement wishlist;
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a") WebElement removewishlist;




	//logout
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a") 
	WebElement logoutbutton;



	CommonPage page;
	static ExtentTest test;
	static ExtentReports report;


	public CommonModuleTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		page=new CommonPage();
	}
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\final_ExtentReportResults.html");
		test = report.startTest("Opencart_Modules");
	}

	public void validateUpdatefunc(WebDriver driver,int r) throws IOException

	{
		File src =new File("OpenCart_ReadData.xlsx");
		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);
		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		String email=sheet1.getRow(r).getCell(1).getStringCellValue();
		String password=sheet1.getRow(r).getCell(2).getStringCellValue();
		page.click(myaccount);
		page.click(login);
		page.setText(email,useremail);
		page.setText(password,pass);
		page.click(submit);

	}
	public void SearchFunction(WebDriver driver) {
		page.click(searchbutton);
		page.setText("laptop", searchbutton);
		page.click(SearchClick);
		page.click(description);
		page.selectByIndex(categoryId,3);
		page.click(subcategory);
		page.click(buttonsearch);

	}

	public void removeFromWishlist(WebDriver driver) {
		page.click(wishlist);
		page.click(removewishlist);
	}
	public void LogoutFnctionTest(WebDriver driver) {
		page.click(myaccount);
		page.click(logoutbutton);

	}
	public void MyOrdersview(WebDriver driver) {
		page.click(myorderbutton);
		page.click(myorderviewclick);
	}
	public void MyOrdersviewDownloads(WebDriver driver) {
		page.click(myorderdownload);
		page.click(myorderdownloadview);
	}
	public void MyordersrewardPoints(WebDriver driver) {
		page.click(myorderreward);
		page.click(myorderrewardview);

	}
	public void MyordersreturnRequest(WebDriver driver) {
		page.click(ordersreturnbutton);}


}






