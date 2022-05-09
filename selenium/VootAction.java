package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class VootAction {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://www.voot.com/");
		
		w.findElement(By.xpath("//*[@id=\"header\"]/div/button")).click();
		w.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/span")).click();
		
		
		Thread.sleep(2000);
		w.close();
	}
}
