package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Alert3 {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("http://demo.automationtesting.in/Alerts.html");
		Actions a=new Actions(w);
		WebElement un1=w.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
		a.moveToElement(un1).doubleClick().perform();
		
		w.findElement(By.cssSelector("button.btn.btn-primary")).click();
		 Alert alert=w.switchTo().alert();

			Thread.sleep(2000);
			alert.dismiss();
			
			w.close();

}
}