package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert2 {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://www.thetrainline.com/");
		w.findElement(By.className("ot-sdk-container")).click();
		//w.findElement(By.id("ontrust-accept-button-handler")).click();

		Alert alert=w.switchTo().alert();
		//String alertmsg=alert.getText();
		//System.out.println(alertmsg);
		
		Thread.sleep(2000);
		alert.accept();
		
		w.close();
		
	}
		
}



