package com.opencart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.opencart.common.CommonPage;

public class LogoutTest {
	WebDriver driver=null;
	static String email,password;

	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	
	@Test(priority=2)
	public void LogoutFunctionTest() {
		
		driver.get("http://localhost/opencartapp/");

		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		WebElement element= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));
		CommonPage.moveToElement(element,driver);
		//		Actions a=new Actions(driver);
		//        a.moveToElement(elemnt1).click().perform();
		WebElement log=driver.findElement(By.xpath("//*[@id=\"common-success\"]/ul/li[3]/a"));
		if(log.isDisplayed()) {

			System.out.println("Your have been logged off");
		}
		else {
			System.out.println("Your account have been logged in");
		}


	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("test passed sucessfully");

	}
}

