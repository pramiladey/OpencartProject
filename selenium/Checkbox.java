package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkbox {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		

		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://book.spicejet.com/");
		
		System.out.println(w.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$FamilyAndFriends")).isSelected());
		Select s=new Select(w.findElement(By.xpath("ControlGroupSearchView$AvailabilitySearchInputSearchView$FamilyAndFriends")));
		
						
				w.quit();
		

}}
