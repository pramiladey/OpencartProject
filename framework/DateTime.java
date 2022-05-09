package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateTime {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.redbus.in/");
		w.findElement(By.className("db")).click();
		w.findElement(By.className("db")).sendKeys("tata");
		Thread.sleep(2000);
		w.findElement(By.id("dest")).click();
		w.findElement(By.id("dest")).sendKeys("kolkata");
		Thread.sleep(2000);
		//w.findElements(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
		w.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
		Thread.sleep(2000);
		w.findElement(By.className("rb-calendar")).click();
		//w.findElement(By.className("monthtitle")).click();
		//w.findElement(By.xpath("/*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[5]/td[5]")).click();
		//w.findElement(By.id("next")).sendKeys("jan");
		Thread.sleep(2000);
		
		
		
		
		


}}
