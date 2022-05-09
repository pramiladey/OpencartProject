package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Script {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.facebook.com");
		System.out.println(w.getTitle());
		System.out.println(w.getCurrentUrl());
		System.out.println(w.getPageSource());
		Thread.sleep(5000);
		w.navigate().back();
		w.quit();
		

}}
