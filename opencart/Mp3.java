package opencart;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mp3 {
	
		public static void main(String args[]) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://localhost/opencartapp/");
			
			driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Show All MP3 Players')]")).click();
			Thread.sleep(2000);
			
			//Sorting 
			Select s = new Select(driver.findElement(By.id("input-sort")));
			s.selectByIndex(2);
			Thread.sleep(2000);
			
			//Show in List
			driver.findElement(By.id("list-view")).click();
			Thread.sleep(2000);

			//Select iPod Touch
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
			Thread.sleep(2000);

			//Add to cart
			
			driver.findElement(By.id("button-cart")).click();
			Thread.sleep(2000);
			Alert alert1=driver.switchTo().alert();
			Thread.sleep(2000);
			alert1.accept();
			Thread.sleep(2000);
			driver.close();
		}

	}


