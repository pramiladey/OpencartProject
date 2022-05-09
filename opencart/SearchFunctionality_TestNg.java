package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchFunctionality_TestNg {
	WebDriver driver=null;

	@Test(groups= {"Regression"})
	public void DriverSetup() {
		//for browser
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32(1)//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();}

	@Test(priority=1)
	public void LoginApp() throws InterruptedException {
		//login

		driver.get("http://localhost/opencartap/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt).click().perform();
		Thread.sleep(2000);

		driver.findElement(By.name("email")).sendKeys("pramiladey65@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pampi@1822");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void SearchFunctionality() throws InterruptedException {
		//search
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("laptop");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void CloseBrowser()
	{
		//close the  browser
		driver.close();
		System.out.println("test passed sucessfully");
	}
}


