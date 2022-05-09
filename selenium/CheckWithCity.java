package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckWithCity {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://book.spicejet.com/");
		w.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
		Select s=new Select(w.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1")));
		
		Thread.sleep(2000);
		
		Select s1=new Select(w.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1" )));
		
		Thread.sleep(2000);
		
		//s.selectByValue("AGR");
		w.close();
		

}}


