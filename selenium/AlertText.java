package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertText {
	
		public static void main(String[] args) throws InterruptedException{
			System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



			WebDriver w=new ChromeDriver();
			w.get("http://demo.automationtesting.in/Alerts.html");
			w.findElement(By.className("analystic")).click();
			w.findElement(By.cssSelector("button.btn.btn-danger")).click();

			Alert alert=w.switchTo().alert();
			//String alertmsg=alert.getText();
			//System.out.println(alertmsg);
			
			Thread.sleep(2000);
			alert.accept();
			
			w.close();
			
		}
			
}
