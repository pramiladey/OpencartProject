package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AfterLogin_SearchFunctionality {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        
		//link of opencart application
		driver.get("http://localhost/opencartapp/");
		//myaccount module
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt).click().perform();
		Thread.sleep(2000);
		
        //login account using email and password
		driver.findElement(By.name("email")).sendKeys("pramiladey65@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pampi@1822");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		//driver.navigate().back();
		//Thread.sleep(2000);
//		//search functionality of opencart application
//		driver.findElement(By.name("search")).clear();
//		driver.findElement(By.name("search")).sendKeys("laptop");
//		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
//		Thread.sleep(2000);
//		driver.close();
		driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();
		//Thread.sleep(2000);
		driver.close();


	}
}
