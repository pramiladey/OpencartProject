package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login_Testing {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		
		

		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://book.spicejet.com/");
		w.findElement(By.xpath("//*[@id=\"Login\"]")).click();;
		// Select s=new Select(w.findElement(By.id("menu-list-login")));
		//s.selectByValue("");
		
		Thread.sleep(2000);
		//System.out.println(w.findElement(By.xpath("//*[@id=ControlGroupSearchView_AvailabilitySearchInputSearchView_FamilyAndFriends]")).isSelected());
		//w.findElement(By.xpath("//*[@id=ControlGroupSearchView_AvailabilitySearchInputSearchView_FamilyAndFriends]")).click();
				
		w.quit();
		}}


