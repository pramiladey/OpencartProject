package framework;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RpdPractice {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		SimpleDateFormat ft=new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss "); 
		
		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.redbus.in/");
		
		w.findElement(By.className("db")).click();
		w.findElement(By.className("db")).sendKeys("tata");
		Thread.sleep(2000);
		w.findElement(By.className("db")).sendKeys(Keys.DOWN);
		w.findElement(By.className("db")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		w.findElement(By.id("dest")).click();
		w.findElement(By.id("dest")).sendKeys("kolkata");
		Thread.sleep(2000);
		w.findElement(By.id("dest")).sendKeys(Keys.DOWN);
		w.findElement(By.id("dest")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/div/label")).click();
		 // Select s1=new Select(w.findElements(By.className("rb-calendar")));
		  w.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table"));
		  w.findElement(By.className("next")).click();
			
		  
		
		w.close();
		
	
}}
