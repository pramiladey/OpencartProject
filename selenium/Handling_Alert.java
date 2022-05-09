package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Alert {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("http://demo.guru99.com/test/delete_customer.php");
		w.findElement(By.name("cusid")).sendKeys("53920");
		w.findElement(By.name("submit")).submit();
		
		Alert alert=w.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println(alertmsg);
		Thread.sleep(2000);
		alert.dismiss();
		w.close();
		
	

}
}