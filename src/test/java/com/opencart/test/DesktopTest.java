package com.opencart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.common.CommonPage;
import com.opencart.common.LoggersExamplePage;

public class DesktopTest {
WebDriver driver=null;
	
	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void openBrowser() throws InterruptedException  {
		driver.get("http://localhost/opencartapp/");
	     //logger.info("Chrome opened successfully!!!");
		
	}
	@Test(priority=13)
	public void openDesktopModule() throws InterruptedException {
        WebElement desktop=driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
        		desktop.click();
        if(desktop.isEnabled()) {
        	System.out.println("Desktop module is enable");
        }
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
		//Thread.sleep(2000);
		
	}
	@Test(priority=14)
	public void sortProductByPrice() throws InterruptedException {
		Select s = new Select(driver.findElement(By.id("input-sort")));
		s.selectByIndex(3);
		//Thread.sleep(2000);
	
	}
	@Test(priority=15)
	public void ShowingByList() throws InterruptedException {
		driver.findElement(By.id("list-view")).click();
		Thread.sleep(2000);
		
		}
	
	@Test(priority=16)
	public void selectProduct() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		//Thread.sleep(2000);
		
	}
	@Test(priority=17)
	public void addToWishlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		//Thread.sleep(5000);
		
	}
	
	@Test(priority=18)
	public void addToCart() throws InterruptedException {
		Select s1 = new Select(driver.findElement(By.id("input-option226")));
		s1.selectByIndex(1);
		//Thread.sleep(2000);
		driver.findElement(By.id("button-cart")).click();
		//Thread.sleep(5000);
		
		//driver.close();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		 LoggersExamplePage.logger.info("Browser closed successfully!!!");
	}


}
