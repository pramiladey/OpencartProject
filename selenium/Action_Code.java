package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Action_Code {
	public static void main(String[] args) throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://www.facebook.com/");
		WebElement un=w.findElement(By.id("email"));
		WebElement pwd=w.findElement(By.id("pass"));
		
		Actions a=new Actions(w);
		Action Aseries=a.moveToElement(un).click().keyDown(un,Keys.SHIFT).sendKeys(un,"demo").build();
		Aseries.perform();
		
		Action Aseries1=a.moveToElement(pwd).click().keyDown(pwd,Keys.SHIFT).sendKeys("ttl").build();
		
		Aseries1.perform();
		Thread.sleep(2000);
		w.close();
		
		

}
}
