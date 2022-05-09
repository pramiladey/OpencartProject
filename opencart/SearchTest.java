package opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest {
	WebDriver driver;
	
	
	@BeforeTest
	public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
        driver=new ChromeDriver();
		
	}
	
	@Test(priority=1)
	public void OpenBrowser() {
		driver.get("http://localhost/opencartapp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void SearchFunctionality() {
		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("laptop");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
		System.out.println("test passed sucessfully");
	}


}
