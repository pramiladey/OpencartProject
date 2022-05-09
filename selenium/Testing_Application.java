package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testing_Application {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		

		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		String baseUrl="https://www.voot.com";
		String expectedTitle="VOOT - Watch Free Online TV Shows, Movies, Kids Shows HD Quality on VOOT. Keep Vooting.";
		//StringBuffer buffer=new StringBuffer();
		
		w.get(baseUrl);
		Thread.sleep(2000);
		
		
		if(w.getTitle().equals(expectedTitle)) {
			System.out.println("Voot App  title  is : "+w.getTitle());
			w.findElement(By.xpath("//*[@id='header']/div/div[2]")).click();
			
			
			
			Thread.sleep(3000);
			
			w.quit();
			}
			else {
				System.out.println(" page title not matched");
			}
			
			
		}
	}


