package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoProjectApp {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		

		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://phptravels.com/demo/");
		w.findElement(By.xpath("/html/body/header/div/nav/a[6]")).click();
		Thread.sleep(2000);
		w.navigate().back();
		w.close();

}}
