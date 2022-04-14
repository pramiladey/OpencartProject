package com.opencart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.opencart.common.CommonPage;

public class SearchTest {
	WebDriver driver=null;

	@Test(priority=1)
	public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().window().maximize();

	}

	@Test(priority=2)
	public void OpenBrowser() {
		driver.get("http://localhost/opencartapp/");
	}

	@Test(priority=3)
	public void SearchButtonClickable() {
		driver.findElement(By.name("search")).clear();
		WebElement laptop=driver.findElement(By.name("search"));
		laptop.sendKeys("laptop");

		if(laptop.isDisplayed()) {
			System.out.println("Search button is clickable");
		}
		else {
			System.out.println("Search button is not clickable");
		}
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		//Thread.sleep(2000);
	}
	@Test(priority=4)
	public void CategoryIdSelected() {

		driver.findElement(By.name("description")).click();
		int num=3;
		WebElement sort=driver.findElement(By.name("category_id"));
         CommonPage.selectByIndex(sort, num);

		if((driver.findElement(By.name("category_id")).isSelected()));
		{
			System.out.println("Selected category will be shown in the list");}
	}
	
	@Test(priority=5)
	public void SubCategoryEnable(){

		WebElement sub=driver.findElement(By.name("sub_category"));
				sub.click();
		
		if(sub.isEnabled()) {
				System.out.println("Tick mark will be shown");
			}
			else {
				System.out.println("Tick mark will not be shown");
			}
		
		driver.findElement(By.id("button-search")).click();
	
		
	}
	@AfterTest
	public void CloseBrowser() {

		driver.close();
		System.out.println("Test passed Sucessfully");
	}
}





