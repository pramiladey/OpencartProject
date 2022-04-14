package com.opencart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mp3Test {
	WebDriver driver=null;
	static String email,password;

	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	 public void Mp3FunctionTest() {
		 driver.get("http://localhost/opencartap/");
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
			
			//Add to cart
			driver.findElement(By.id("button-cart")).click();
			
		 
	 }
	@Test(priority=2)
	public void closeBrowser() {
		driver.close();
	}

}
