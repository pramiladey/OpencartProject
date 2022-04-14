package com.opencart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddressBookTest {
	WebDriver driver=null;
	static String email,password;

	@Test(groups= {"Regression"})
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void AddressTest() throws InterruptedException {
		driver.get("http://localhost/opencartap/");
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
		driver.findElement(By.id("input-firstname")).sendKeys("Neha");	
		driver.findElement(By.id("input-lastname")).sendKeys("Roy");
		driver.findElement(By.id("input-company")).sendKeys("PSL");
		driver.findElement(By.id("input-address-1")).sendKeys("House No. 103, XYZ street");
		driver.findElement(By.id("input-city")).sendKeys("Durgapur");
		driver.findElement(By.id("input-postcode")).sendKeys("98765");
		
		Select country = new Select(driver.findElement(By.xpath("//*[@id=\"input-country\"]")));
		country.selectByVisibleText("India");
		
		Actions action = new Actions(driver);
		
		WebElement s = driver.findElement(By.xpath("//select[@id='input-zone']"));
		
		Action as = a.moveToElement(s).click().keyDown(s, Keys.SHIFT).sendKeys(s, "West Bengal").build();
		as.perform();
		
		//radio button 	- 'yes'
		//d.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]/input")).click();
		//Thread.sleep(500);
		// click continue button	
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
