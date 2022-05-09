/**
 * 
 */
package com.psl.OpenCart.Tests;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.CurrencyPage;
import com.psl.OpenCart.pages.ShoppingCartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author segu_revathi
 *
 */
public class TestCurrency {
	 WebDriver driver;
	 ShoppingCartPage scPage;
	 CurrencyPage cur;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro");
		LoggersExample.logger.info("Browser opened successfully!!!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cur=new CurrencyPage(driver);
	}
	
	@Test
	public void validateEuroCurrencyfunc()
	{
		Assert.assertTrue(cur.validateEuroCurrency(driver));
		LoggersExample.logger.info("Tested Euro currency functionality.");
	}
	
	@Test
	public void validatePoundCurrencyfunc()
	{
		Assert.assertTrue(cur.validatePoundCurrency(driver));
		LoggersExample.logger.info("Tested Pound currency functionality.");
	}
	
	@Test
	public void validateUSDollarCurrencyfunc()
	{
		Assert.assertTrue(cur.validateUSDollarCurrency(driver));
		LoggersExample.logger.info("Tested USDollar functionality.");
	}
	
	@AfterTest
	public void closeBrowsers()
	{
		driver.close();
		LoggersExample.logger.info("Browser closed successfully!!!");
	}
}
