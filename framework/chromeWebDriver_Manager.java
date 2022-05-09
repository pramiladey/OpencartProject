package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeWebDriver_Manager {
	
		public static void main(String[] args) throws InterruptedException {
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			
			// Navigate to the demoqa website
			driver.get("https://www.google.com");
			driver.findElements(By.name("q")).clear();
			//driver.findElements(By.name("q")).sendKeys("happy");
			driver.findElement(By.name("q")).sendKeys("happy");
			//driver.findElement(By.name("btnK")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			 
			
			driver.quit();

		}

	}

	