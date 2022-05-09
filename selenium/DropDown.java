package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://book.spicejet.com/");
		w.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency")); 
		Select s=new Select(w.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency")));
		s.selectByValue("INR");

		Thread.sleep(2000);
		s.selectByIndex(5);
		Thread.sleep(2000);
		s.selectByVisibleText("USD");
		Thread.sleep(2000);


		//drop_down

		//w.findElement(By.id("divpaxinfo")).click();
		//Select s1=new Select(w.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")));
		//s1.selectByValue("5");
		//Select s2=new Select(w.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD")));
		//s1.selectByValue("4");
		//Select s3=new Select(w.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_INFANT")));
		//s3.selectByIndex(2);

		w.close();}}


	
