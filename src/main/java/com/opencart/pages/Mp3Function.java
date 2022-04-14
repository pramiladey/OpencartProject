package com.opencart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mp3Function {
	

		public static void main(String args[]) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			
			driver.get("http://localhost/opencartapp/");
			
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
			
			driver.close();
		}

	}


