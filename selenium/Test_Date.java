package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Date {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver drive=new ChromeDriver();
		drive.get("https://book.spicejet.com/");
		drive.findElement(By.id("custom_date_picker_id_1")).click();
		drive.findElement(By.id("custom_date_picker_id_2")).click();
		Thread.sleep(2000);
		
		drive.close();
		
		
		

}}
