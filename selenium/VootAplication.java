package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class VootAplication {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.get("https://www.voot.com/");
		WebElement un=w.findElement(By.xpath("//*[@id='header']/div/div[2]"));
		//WebElement pwd=w.findElement(By.id("pass"));
		//WebElement un1=w.findElement(By.xpath("//*[@id=\"standard-full-width\"]"));
		
		
		Actions a=new Actions(w);
		Action Aseries=a.moveToElement(un).click().keyDown(un,Keys.SHIFT).sendKeys(un,"trending shows").build();
		Aseries.perform();
		
		//Action Aseries1=a.moveToElement(un1).click().contextClick().build();
		//Aseries1.perform();
		
		Thread.sleep(3000);
		//w.close();
		

}}

	


