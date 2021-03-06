package com.psl.OpenCart.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTablets 
{
	
	 WebDriver driver;
	   
	   @BeforeTest  // annotation
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost/Opencart");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Chrome opened Sucessfully");
		}
	   

	@Test(priority = 1)
	   public void verifyTabletsModuleInHomePage() throws InterruptedException
	   {
		// Checking whether the Tablets module is present in the Home page
		   boolean flag= driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a")).isDisplayed();
		   Assert.assertTrue(flag);
		   System.out.println("tablets module is present in the Home page");
	   }
	
	@Test(priority = 2)
	public void verifyTabletstsIsClickable() throws InterruptedException
	{
		 //Clicking on the Tablets module
		   driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a")).click();
	}
	
	@Test(priority = 3)
	// Adding Samsung Galaxy Tab 10.1 to the cart
	public void addingToCart() throws InterruptedException
	{
		   verifyTabletstsIsClickable();
		   //clicking on the list option
		   driver.findElement(By.xpath("//*[@id=\"list-view\"]/i")).click();
		   
		   //Clicking on the product
		   driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/a/img")).click();
		   
		   //Scrolling
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,300)");
		   
		   //click on add to cart
		   driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		   String text=driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		  LoggersExample.logger.info(text);
		 
	}
	
	@AfterTest
	 public void closeBrowser()
	 {
		 driver.close();
	 }
}
