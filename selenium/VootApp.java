package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VootApp {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.voot.com");
		w.findElement(By.xpath("//*[@id=\\\"header\\\"]/div/button")).click();
		w.findElement(By.xpath("//*[@id=\"standard-full-width\"]")).sendKeys("bigg boss");
		w.findElement(By.xpath("//*[@id=\"standard-full-width\"]")).sendKeys(Keys.ENTER);
		
		
		
		
		Thread.sleep(2000);
		
		
		 
		

}}
