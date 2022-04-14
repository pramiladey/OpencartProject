package com.opencart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MyOrdersTest {
	WebDriver driver=null;
	static String email,password;

	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority =1)
	public void viewMyOrders() throws InterruptedException {
		driver.get("http://localhost/opencartapp/");
		//myaccount module
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt).click().perform();
		Thread.sleep(2000);
		
        //login account using email and password
		driver.findElement(By.name("email")).sendKeys("pramiladey65@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pampi@1822");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	@Test(priority =2)
	public void viewDownloads() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	@Test(priority =3)
	public void rewardPoints() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	@Test(priority =4)
	public void returnRequest() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
