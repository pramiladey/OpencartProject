package selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestingFlu {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");


 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//*[@id='content]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='start']/button")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='finish']/h4")).getText());
		//Thread.sleep(10000);
		
		 Wait <WebDriver> wait=new  FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
	    
		WebElement foo=wait.until (new Function<WebDriver,WebElement>() 
				{
			public WebElement apply(WebDriver driver) {
			      return driver.findElement(By.xpath("//*[@id='finish']/h4"));}
			
				});
		
		
		
	driver.navigate().back();
	driver.close();
	
}}

