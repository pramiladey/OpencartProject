package framework;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationRedBus {
public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		SimpleDateFormat ft=new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss "); 
		



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.redbus.in/");
		w.findElement(By.id("manageHeaderdd")).click();
		
		w.findElement(By.xpath("//*[@id=\"hmb\"]/div[2]/ul/li[2]")).click();
		
		w.findElement(By.name("tin")).sendKeys("102");
		w.findElement(By.name("email")).sendKeys("@gmail.com");
		w.findElement(By.className("button-comp-lbl")).click();
		//w.findElement(By.className("form-select-passenger-container")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		w.navigate().back();
		//w.findElement(By.id("manageHeaderdd")).click();
      // w.findElement(By.xpath("//*[@id=\"hmb\"]/div[2]/ul/li[5]")).click();
		
		//w.findElement(By.name("Tin")).sendKeys("202");
		//w.findElement(By.name("Email")).sendKeys("@gmail.com");
		//w.findElement(By.xpath("//*[@id=\"ticketSearch\"]")).click();
		//Thread.sleep(3000);
		//w.navigate().back();
		
		w.findElement(By.className("db")).click();
		w.findElement(By.className("db")).sendKeys("tata");
		Thread.sleep(2000);
		w.findElement(By.className("db")).sendKeys(Keys.DOWN);
		w.findElement(By.className("db")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		w.findElement(By.id("dest")).click();
		w.findElement(By.id("dest")).sendKeys("kolkata");
		//w.findElement(By.className("dest").sendKeys(Keys.DOWN);
		w.findElement(By.className("dest")).sendKeys(Keys.DOWN);
		w.findElement(By.className("dest")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	
		w.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
		Thread.sleep(2000);
		w.findElement(By.className("rb-calendar")).click();
		Thread.sleep(2000);
		
		w.findElement(By.id("redBus")).click();
		Thread.sleep(2000);
		w.findElement(By.id("txtSource")).click();
		w.findElement(By.id("txtSource")).sendKeys("banglore");
		Thread.sleep(2000);
		w.findElement(By.id("txtDestination")).click();
		w.findElement(By.id("txtDestination")).sendKeys("Hydrabaad");
		Thread.sleep(2000);
		w.findElement(By.id("txtOnwardCalendar")).click();
		w.findElement(By.id("txtOnwardCalendar")).sendKeys("30-Dec-2021");
		//Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button")).click();
		//w.findElement(By.className("D120-search-btn")).click();
		Thread.sleep(3000);
		w.navigate().back();
		w.close();
		

}}



